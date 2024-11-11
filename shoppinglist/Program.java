import java.util.ArrayList;
import java.util.List;

class Program {
    private static final String FILE_NAME = "shoppingList.csv";
    private static CommandController controller;
    public static void main(String[] args) {
        FileIO file = null;
        List<String> list = null;
        try
        {
            file = new FileIO(FILE_NAME);
            list = file.read();
            ShoppingList shoppingList = new ShoppingList(list);
            controller = new CommandController(shoppingList, file);
            controller.execute(Commands.help, new ArrayList<String>());
            while(true)
            {
                inputController();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return;
        }
    }

    public static void inputController()
    {
        System.out.print("> ");
        String input = System.console().readLine();
        
        if(input == null || input.trim().isEmpty())
        {
            return;
        }

        ArrayList<String> parts = new ArrayList<String>();
        String[] split = input.split(" ");

        for (String s : split)
        {
            parts.add(s);
        }

        String commandString = parts.get(0);
        parts.remove(0);

        try
        {
            Commands command = Commands.valueOf(commandString.toLowerCase());
            controller.execute(command, parts);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid command" + e.getMessage());
        }
    }
}