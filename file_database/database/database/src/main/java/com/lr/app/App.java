package com.lr.app;

public class App {
    public static void main(String[] args) {
        CommandController commandController = new CommandController("CREATE TABLE fruits (name STRING, quantity INT);");
        commandController.execute();

    }
}
