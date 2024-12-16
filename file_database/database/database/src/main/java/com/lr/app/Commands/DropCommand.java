package com.lr.app.Commands;

import java.io.IOException;

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
    public void execute() throws RuntimeException
    {
        Table table = new Table(tableName);
        try
        {
            table.delete();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println("Table " + tableName + " dropped successfully");
    }
}
