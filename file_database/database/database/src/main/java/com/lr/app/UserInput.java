package com.lr.app;

import java.util.Scanner;

public class UserInput
{
    private Scanner scanner;

    public UserInput()
    {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput()
    {
        String input = scanner.nextLine();
        return input;
    }

    public void close()
    {
        scanner.close();
    }
}
