package com.lr.app;

import java.util.ArrayList;

public class TableData
{
    private Records records;
    private ArrayList<Column> columns;

    public TableData(Records records, ArrayList<Column> columns)
    {
        this.records = records;
        this.columns = columns;
    }

    public TableData()
    {
        this.records = new Records(null);
        this.columns = new ArrayList<Column>();
    }

    public Records getRecords()
    {
        return records;
    }

    public ArrayList<Column> getColumns()
    {
        return columns;
    }
}
