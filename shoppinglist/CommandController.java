import java.util.ArrayList;

public class CommandController {
    private ShoppingList shoppingList;
    private FileIO file;

    public CommandController(ShoppingList shoppingList, FileIO file) {
        this.shoppingList = shoppingList;
        this.file = file;
    }

    public void execute(Commands command, ArrayList<String> list) {
        try {
            command.validate(list);
            switch (command) {
                case print:
                    this.shoppingList.print();
                    break;
                case help:
                    for (Commands c : Commands.values()) {
                        System.out.println(c + " - " + c.getDescription());
                    }
                    break;
                case add:
                    if (list.size() == 1)
                    {
                        this.shoppingList.add(list.get(0), "");
                        break;
                    }
                    this.shoppingList.add(list.get(0), list.get(1));
                    break;
                case remove:
                    this.shoppingList.remove(list.get(0), list.get(1));
                    break;
                case quit:
                    this.file.write(this.shoppingList.toList());
                    System.exit(0);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}