import java.util.ArrayList;

public enum Commands {
    print("Prints the shopping list", 0, 0),
    help("Prints the available commands", 0, 0),
    add("Adds an item to the shopping list", 1, 2),
    remove("Removes an item from the shopping list", 2, 2),
    quit("Exits the program", 0, 0);

    private final String DESCRIPTION;
    private final int MINARGS;
    private final int MAXARGS;

    Commands(String description, int minArgs, int maxArgs) {
        this.DESCRIPTION = description;
        this.MINARGS = minArgs;
        this.MAXARGS = maxArgs;
    }

    public String getDescription() {
        return this.DESCRIPTION;
    }

    public void validate(ArrayList<String> args) throws IllegalArgumentException
    {
        if (args.size() < this.MINARGS || args.size() > this.MAXARGS)
        {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
}
