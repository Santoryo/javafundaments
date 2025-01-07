package com.lr.app;

public class App {
    public static void main(String[] args) {

        System.out.println("Welcome to the LRDBMS");
        while(true)
        {
            UserInput userInput = new UserInput();
            System.out.print("> ");
            String input = userInput.getUserInput();

            try
            {
                CommandController commandController = new CommandController(input);
                commandController.execute();
            }
            catch (DatabaseException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}
