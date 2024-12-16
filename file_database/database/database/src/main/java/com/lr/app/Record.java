package com.lr.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Record {
    private Map<String, Object> values;

    public Record(Map<String, Object> data)
    {
        this.values = this.set(data);
    }

    public Record()
    {
        this.values = new HashMap<>();
    }

    public Object get(String name)
    {
        return values.get(name);
    }

    public void set(String name, Object value)
    {
        values.put(name, value);
    }

    public Map<String, Object> set(Map<String, Object> data)
    {
        this.values = data;
        return data;
    }

    public boolean matches(String column, String value)
    {
        return Objects.equals(String.valueOf(values.get(column)), value);
    }

    public boolean matches(Record other)
    {
        return this.values.equals(other.values);
    }

    public Map<String, Object> getValues()
    {
        return values;
    }

    @Override
    public String toString()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
