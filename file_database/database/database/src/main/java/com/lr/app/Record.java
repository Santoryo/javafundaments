package com.lr.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Record {
    private final Map<String, Object> data;

    public Record(Map<String, Object> data)
    {
        this.data = new HashMap<>(data);
    }

    public Object get(String name)
    {
        return data.get(name);
    }

    public void set(String name, Object value)
    {
        data.put(name, value);
    }

    public boolean matches(String column, String value)
    {
        return Objects.equals(String.valueOf(data.get(column)), value);
    }

    @Override
    public String toString()
    {
        return data.toString();
    }
}
