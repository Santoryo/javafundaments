package com.lr.app;

import java.util.ArrayList;
import com.lr.app.Commands.CreateCommand;
import com.lr.app.Commands.DropCommand;
import com.lr.app.Commands.InsertCommand;
import com.lr.app.Commands.SelectCommand;
import com.lr.app.Commands.UpdateCommand;

public class CommandController {
    private Tokenizer tokenizer;
    private boolean whereClause = false;

    public CommandController(String input) {
        tokenizer = new Tokenizer(input);
    }

    public void execute() throws DatabaseException {
        String command = tokenizer.nextToken().toLowerCase();

        if (tokenizer.getTokens().toString().toLowerCase().contains("where")) {
            whereClause = true;
        }

        switch (command) {
            case "select":
                executeSelect();
                break;
            case "drop":
                executeDrop();
                break;
            case "insert":
                executeInsert();
                break;
            case "exit":
                System.exit(0);
                break;
            case "update":
                executeUpdate();
                break;
            case "create":
                executeCreate();
                break;
            case "delete":
                executeDelete();
                break;
            default:
                throw new IncorrectSyntax("Command " + command + " not recognized");
        }
    }

    private void executeSelect() throws DatabaseException {
        ArrayList<String> columns = new ArrayList<>();
        String column = tokenizer.nextToken();
        if (column.equals("*")) {
            tokenizer.nextToken();
            Table table = new Table(tokenizer.nextToken());

            if (whereClause) {
                Records records = executeWhere(table);
                table.setRecords(records);
            }

            SelectCommand selectCommand = new SelectCommand(table, "*");
            selectCommand.execute();
        } else {
            columns.add(column);
            while (tokenizer.hasNextToken()) {
                String token = tokenizer.nextToken();
                if (token.equals(",")) {
                    continue;
                } else if (token.toLowerCase().equals("from")) {
                    break;
                }
                columns.add(token);
            }
            Table table = new Table(tokenizer.nextToken());

            if (whereClause) {
                Records records = executeWhere(table);
                table.setRecords(records);
            }

            SelectCommand selectCommand = new SelectCommand(table, columns);
            selectCommand.execute();
        }
    }

    private void executeDrop() throws DatabaseException {
        String tableName = tokenizer.nextToken();
        DropCommand dropCommand = new DropCommand(tableName);
        dropCommand.execute();
    }

    private void executeInsert() throws IllegalArgumentException {
        tokenizer.nextToken(); // INTO
        String tableName = tokenizer.nextToken();
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        if (!tokenizer.nextToken().equals("(")) {
            throw new IllegalArgumentException("Expected ( before " + tokenizer.nextToken());
        }
        while (tokenizer.hasNextToken()) {
            String token = tokenizer.nextToken();
            if (token.equals(",")) {
                continue;
            }
            if (token.equals(")")) {
                break;
            }
            columns.add(token);
        }

        if (!tokenizer.nextToken().toLowerCase().equals("values")) {
            throw new IllegalArgumentException("Expected VALUES before " + tokenizer.nextToken());
        }

        if (!tokenizer.nextToken().equals("(")) {
            throw new IllegalArgumentException("Expected ( before " + tokenizer.nextToken());
        }

        while (tokenizer.hasNextToken()) {
            String token = tokenizer.nextToken();
            if (token.equals(",")) {
                continue;
            }
            if (token.equals(")")) {
                break;
            }
            values.add(token);
        }

        InsertCommand insertCommand = new InsertCommand(tableName, columns, values);
        try {
            insertCommand.execute();
        } catch (Exception e) {
            System.out.println("Error inserting record");
            System.out.println(e.getMessage());
        }
    }

    private Records executeWhere(Table table) throws DatabaseException {
        tokenizer.nextToken(); // WHERE
        String column = tokenizer.nextToken();
        String operator = tokenizer.nextToken();
        String value = tokenizer.nextToken();

        Filter filter = new Filter(table.getRecords(), column, operator, value);
        return filter.getResults();
    }

    private void executeUpdate() throws DatabaseException {
        String tableName = tokenizer.nextToken();
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<Object> values = new ArrayList<>();
        if (!tokenizer.nextToken().equals("SET")) {
            throw new IllegalArgumentException("Expected SET before " + tokenizer.nextToken());
        }
        while (tokenizer.hasNextToken() && !tokenizer.peekNext().equals("WHERE")) {
            String token = tokenizer.nextToken();
            if (token.equals(",")) {
                continue;
            }
            if (token.equals("=")) {
                token = tokenizer.nextToken();
                values.add(token);
                continue;
            }
            columns.add(token);
        }

        Records recordsToChange = executeWhere(new Table(tableName));
        UpdateCommand updateCommand = new UpdateCommand(tableName, columns, values, recordsToChange);
        try {
            updateCommand.execute();
        } catch (Exception e) {
            System.out.println("Error updating record");
            System.out.println(e.getMessage());
        }
    }

    private void executeCreate() {
        String token = tokenizer.nextToken();
        if (!token.toLowerCase().equals("table")) {
            System.out.println("Expected TABLE before " + token);
            return;
        }
        String tableName = tokenizer.nextToken();
        ArrayList<Column> columns = new ArrayList<>();
        if (!tokenizer.nextToken().equals("(")) {
            System.out.println("Expected ( before " + tokenizer.nextToken());
            return;
        }
        while (tokenizer.hasNextToken()) {
            String column = tokenizer.nextToken();
            if (column.equals(",")) {
                continue;
            }
            if (column.equals(")")) {
                break;
            }
            String type = tokenizer.nextToken();
            columns.add(new Column(column, type));
        }

        System.out.println("Creating table " + tableName);
        System.out.println("Columns: " + columns.toString());

        CreateCommand createCommand = new CreateCommand(tableName, columns);
        try {
            createCommand.execute();
        } catch (DatabaseException e) {
            System.out.println("Error creating table");
            System.out.println(e.getMessage());
        }
    }

    private void executeDelete() throws DatabaseException {
        String tableName = tokenizer.nextToken();
        Records records = executeWhere(new Table(tableName));
        Table table = new Table(tableName);
        table.setRecords(records);
        table.deleteRecords(records);
    }
}
