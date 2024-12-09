package com.lr.app;

import java.util.ArrayList;

public class Table {
    private final String name;
    private final ArrayList<Field> fields;

    public Table(String name, ArrayList<Field> fields)
    {
        this.name = name;
        this.fields = new ArrayList<>(fields);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Field> getFields()
    {
        return fields;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
