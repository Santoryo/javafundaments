package com.lr.app;

public class IncorrectSyntax extends DatabaseException {
    public IncorrectSyntax(String message)
    {
        super("[Syntax Error] " + message);
    }
    
}
