package com.lr.app;

public class Field {
    private final String name;
    private final String type;

    public Field(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return name + "(" + type + ")";
    }

}
