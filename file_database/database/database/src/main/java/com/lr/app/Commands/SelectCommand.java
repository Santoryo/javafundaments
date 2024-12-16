package com.lr.app.Commands;

import java.util.ArrayList;
import com.lr.app.Table;

public class SelectCommand extends Command
{
    private Table table;
    private ArrayList<String> columns;

    public SelectCommand(Table table, ArrayList<String> columns) throws IllegalArgumentException
    {
        super("select", "Select records from the table");
        this.table = table;
        for (String column : columns)
        {
            if (table.getColumn(column) == null)
            {
                throw new IllegalArgumentException("Column " + column + " does not exist in the table");
            }
        }
        this.columns = columns;
    }

    public SelectCommand(Table table, String columnString) throws IllegalArgumentException
    {
        super("select", "Select records from the table");
        this.table = table;
        if(!columnString.equals("*"))
        {
            throw new IllegalArgumentException("Only * is supported for now");
        }
        this.columns = table.getColumnNames();
    }

    @Override
    public void execute()
    {
        for (String column : columns)
        {
            System.out.format("%-20s", column);
        }
        System.out.println();
    
        for (int i = 0; i < columns.size() * 20; i++)
        {
            System.out.print("-");
        }

        System.out.println();

        for (int i = 0; i < table.getRecords().getData().size(); i++)
        {
            for (String column : columns)
            {
                System.out.format("%-20s", table.getRecords().get(i).get(column));
            }
            System.out.println();
        }
        
    }
    
}
