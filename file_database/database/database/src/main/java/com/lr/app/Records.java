package com.lr.app;

import java.util.ArrayList;
import java.util.List;

public class Records
{
    private List<Record> data = new ArrayList<>();

    public Records(List<Record> records)
    {
        this.data = records;
    }

    public Records()
    {
        this.data = new ArrayList<>();
    }

    public List<Record> getData()
    {
        return data;
    }

    public void add(Record record)
    {
        data.add(record);
    }

    public void remove(Record record)
    {
        data.remove(record);
    }

    public void update(Record record)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i).equals(record))
            {
                data.set(i, record);
                break;
            }
        }
    }

    public void remove(int index)
    {
        data.remove(index);
    }

    public Record get(int index)
    {
        return data.get(index);
    }

    @Override
    public String toString()
    {
        return data.toString();
    }

    public boolean contains(Record record) {
        return data.contains(record);
    }
}
