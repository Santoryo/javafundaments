package com.lr.app;

public enum DataTypes {
    STRING("string"),
    INTEGER("integer"),
    DOUBLE("double"),
    BOOLEAN("boolean"),
    UNKNOWN("unknown");

    private final String type;

    DataTypes(String type)
    {
        this.type = type;
    }

    @Override public String toString()
    {
        return type;
    }

    public DataTypes fromString(String type)
    {
        for (DataTypes dataType : DataTypes.values())
        {
            if (dataType.toString().equals(type))
            {
                return dataType;
            }
        }
        return DataTypes.UNKNOWN;
    }
}
