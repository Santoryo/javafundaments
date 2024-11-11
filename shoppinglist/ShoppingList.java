import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingList {
    private HashMap<String, List<String>> shoppingList;

    public ShoppingList(List<String> csvList)
    {
        this.shoppingList = new HashMap<>();
        if(csvList.size() == 0)
        {
            return;
        }

        for (var line : csvList)
        {
            var parts = line.split(",");
            List<String> items = new ArrayList<>();
            for (int i = 1; i < parts.length; i++)
            {
                items.add(parts[i]);
            }
            this.shoppingList.put(parts[0].trim(), items);
        }
    }

    public void add(String category, String item)
    {
        if (!this.shoppingList.containsKey(category))
        {
            this.shoppingList.put(category, new ArrayList<>());
        }

        if(!item.isEmpty())
        {
            this.shoppingList.get(category).add(item);
        }
    }

    public void remove(String category, String item)
    {
        if (this.shoppingList.containsKey(category))
        {
            this.shoppingList.get(category).remove(item);
            return;
        }
        throw new IllegalArgumentException("Category not found");
    }

    public void print()
    {
        for (var category : this.shoppingList.keySet())
        {
            System.out.println(category);
            for (var item : this.shoppingList.get(category))
            {
                System.out.println("  - " + item);
            }
        }
    }

    public List<String> toList()
    {
        List<String> list = new ArrayList<>();
        for (var category : this.shoppingList.keySet())
        {
            var items = this.shoppingList.get(category);
            var line = category;
            for (var item : items)
            {
                line += "," + item;
            }
            list.add(line);
        }

        return list;
    }
}
