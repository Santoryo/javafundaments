package com.lr.app;

public class DatabaseException extends Exception {
    public DatabaseException(String message)
    {
        super("[DB Exception] " + message);
    }
    
}
