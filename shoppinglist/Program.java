import java.io.IOException;
import java.util.List;

class Program {
    private static final String FILE_NAME = "shoppingList.csv";
    public static void main(String[] args) {
        // 1. open shoping list, if it doesn't exist create it
        FileIO file = null;
        List<String> list = null;
        try
        {
            file = new FileIO(FILE_NAME);
            list = file.read();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        ShoppingList shoppingList = new ShoppingList(list);
        shoppingList.print();
        shoppingList.add("sakowicz", "bike");
        shoppingList.add("sakowicz", "car");
        shoppingList.add("sakowicz", "plane");
        shoppingList.add("sakowicz", "train");
        shoppingList.add("sakowicz", "bus");
        shoppingList.add("sakowicz", "boat");
        shoppingList.print();


        
        // 2. read shopping list
        // 3. run the loop to add new items, categories
        // 4. on "exit" command gracefully close the files, and exit
    }
}