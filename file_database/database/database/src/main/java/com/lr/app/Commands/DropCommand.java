package com.lr.app.Commands;

import com.lr.app.DatabaseException;
import com.lr.app.Table;

public class DropCommand extends Command
{
    private String tableName;

    public DropCommand(String tableName)
    {
        super("drop", "Drops a table");
        this.tableName = tableName;
    }

    @Override
    public void execute() throws DatabaseException
    {
        Table table = new Table(tableName);
        table.delete();
        System.out.println("Table " + tableName + " dropped successfully");
    }
}
