package com.lr.app.Commands;

import java.util.ArrayList;

import com.lr.app.Column;
import com.lr.app.Table;

public class CreateCommand extends Command
{   
    private String tableName;
    private ArrayList<Column> columns;

    public CreateCommand(String tableName, ArrayList<Column> columns)
    {
        super("create", "Create a new table");
        this.tableName = tableName;
        this.columns = columns;
    }

    public void execute() throws Exception
    {
        Table table = new Table(tableName);
        for(Column column : columns)
        {
            table.addColumn(column);
        }
        table.save();
        System.out.println("Table " + tableName + " created successfully");
    }
    
}
