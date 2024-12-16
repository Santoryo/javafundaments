package com.lr.app.Commands;

import java.util.ArrayList;
import com.lr.app.Table;
import com.lr.app.Records;

public class UpdateCommand extends Command
{
    private String tableName;
    private ArrayList<Object> values;
    private ArrayList<String> columns;
    private Records recordsToChange;

    public UpdateCommand(String tableName, ArrayList<String> columns, ArrayList<Object> values, Records recordsToChange) throws IllegalArgumentException
    {
        super("update", "Updates a row in a table");
        this.tableName = tableName;
        this.columns = columns;
        this.values = values;
        this.recordsToChange = recordsToChange;
    }

    @Override
    public void execute() throws Exception
    {
        Table table = new Table(tableName);
        table.updateRecords(columns, values, recordsToChange);
        System.out.println("Record upadted successfully");
    }
}
