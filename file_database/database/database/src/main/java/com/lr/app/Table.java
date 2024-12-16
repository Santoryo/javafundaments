package com.lr.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.ToNumberPolicy;

public class Table {
    private final String name;
    private final ArrayList<Column> columns;
    private Records records;

    public Table(String name) {
        this.name = name;

        FileIO file = new FileIO("data/" + name + ".json");
        if (file.exists()) {
            String data = file.read();
            Gson gson = new GsonBuilder().setPrettyPrinting().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                    .create();
            TableData tableData = gson.fromJson(data, TableData.class);
            this.records = tableData.getRecords();
            this.columns = tableData.getColumns();
        } else {
            this.records = new Records();
            this.columns = new ArrayList<Column>();
        }
    }

    public void addColumn(String name, String type) {
        if (columnExists(name)) {
            throw new IllegalArgumentException("Column (" + name + ") already exists");
        }

        Column column = new Column(name, type);
        columns.add(column);
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addColumn(Column column) {
        if (columnExists(column.getName())) {
            throw new IllegalArgumentException("Column (" + column.getName() + ") already exists");
        }

        columns.add(column);
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRecord(Record record) throws IllegalArgumentException, IOException {
        Map<String, Object> data = record.getValues();

        for (String key : data.keySet()) {
            if (!columnExists(key)) {
                throw new IllegalArgumentException("Column (" + key + ") does not exist");
            }
            if (!DataTypeIdentifier.determineDataType(data.get(key)).equals(getColumn(key).getType())) {
                throw new IllegalArgumentException("Data type mismatch for column (" + key + "). Expected "
                        + getColumn(key).getType() + " but got " + DataTypeIdentifier.determineDataType(data.get(key)));
            }
        }
        records.add(record);
        save();
    }

    public void updateRecords(ArrayList<String> keys, ArrayList<Object> values, Records recordsToChange)
            throws IllegalArgumentException, IOException {

        for (Record record : records.getData()) {
            for (Record recordToChange : recordsToChange.getData()) {
                boolean match = record.matches(recordToChange);
                if (match) {
                    for (int i = 0; i < keys.size(); i++) {
                        String key = keys.get(i);
                        Object value = values.get(i);
                        if (!columnExists(key)) {
                            throw new IllegalArgumentException("Column (" + key + ") does not exist");
                        }

                        JsonElement jsonElement = JsonParser.parseString(value.toString());

                        if (jsonElement.getAsJsonPrimitive().isNumber()) {
                            record.set(key, Integer.parseInt(jsonElement.getAsString()));
                        } else if (jsonElement.getAsJsonPrimitive().isBoolean()) {
                            record.set(key, true);
                        } else {
                            record.set(key, jsonElement.getAsString());
                        }
                    }
                }
            }
        }

        save();
    }

    public void save() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();
        TableData tableData = new TableData(records, columns);
        String json = gson.toJson(tableData);

        FileIO file = new FileIO("data/" + name + ".json");
        file.write(json);
    }

    public void delete() throws IOException {
        FileIO file = new FileIO("data/" + name + ".json");
        file.delete();
    }

    public boolean columnExists(String name) {
        for (Column column : columns) {
            if (column.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public Column getColumn(String name) {
        for (Column column : columns) {
            if (column.getName().equals(name)) {
                return column;
            }
        }

        return null;
    }

    public void removeColumn(String name) throws IllegalArgumentException, IOException {
        int idx = -1;
        for (Column column : columns) {
            if (column.getName().equals(name)) {
                idx = columns.indexOf(column);
            }
        }

        for (Record record : records.getData()) {
            record.getValues().remove(name);
        }

        columns.remove(idx);

        if (idx == -1) {
            throw new IllegalArgumentException("Column (" + name + ") does not exist");
        }

        save();
    }

    public Records getRecords() {
        return records;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public ArrayList<String> getColumnNames() {
        ArrayList<String> columnNames = new ArrayList<>();
        for (Column column : columns) {
            columnNames.add(column.getName());
        }

        return columnNames;
    }

    public void setRecords(Records records) throws IOException {
        this.records = records;
    }
}
