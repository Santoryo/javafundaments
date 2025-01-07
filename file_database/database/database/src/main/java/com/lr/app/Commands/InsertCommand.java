package com.lr.app.Commands;

import java.io.IOException;
import java.util.ArrayList;

import com.lr.app.Table;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lr.app.DatabaseException;
import com.lr.app.Record;

public class InsertCommand extends Command
{
    private String tableName;
    private ArrayList<String> values;
    private ArrayList<String> columns;

    public InsertCommand(String tableName, ArrayList<String> columns, ArrayList<String> values) throws IllegalArgumentException
    {
        super("insert", "Inserts a row into a table");
        this.tableName = tableName;
        this.columns = columns;
        this.values = values;
    }

    @Override
    public void execute() throws DatabaseException
    {
        Table table = new Table(tableName);
        Record record = new Record();

        for(int i = 0; i < columns.size(); i++)
        {
            String column = columns.get(i);
            String value = values.get(i);
            if(table.getColumn(columns.get(i)) == null)
            {
                throw new IllegalArgumentException("Column " + columns.get(i) + " does not exist in the table");
            }
            JsonElement jsonElement = JsonParser.parseString(value);

            if (jsonElement.getAsJsonPrimitive().isNumber())
            {
                record.set(column, Integer.parseInt(jsonElement.getAsString()));
            }
            else if (jsonElement.getAsJsonPrimitive().isBoolean())
            {
                record.set(column, true);
            }
            else
            {
                record.set(column, jsonElement.getAsString());
            }
        }

        table.addRecord(record);
        System.out.println("Record inserted successfully");
    }
}
