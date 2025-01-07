package com.lr.app.Commands;

public enum CommandEnum {
    CREATE("create", "Create a new table"),
    DROP("drop", "Drops a table"),
    INSERT("insert", "Insert a new row"),
    SELECT("select", "Select rows from a table"),
    DELETE("delete", "Delete rows from a table"),
    UPDATE("update", "Update rows in a table"),
    EXIT("exit", "Exit the program");

    private String name;
    private String description;

    CommandEnum(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public static CommandEnum getCommand(String command)
    {
        for(CommandEnum commandEnum : CommandEnum.values())
        {
            if(commandEnum.getName().equals(command))
            {
                return commandEnum;
            }
        }
        return null;
    }
    
}
