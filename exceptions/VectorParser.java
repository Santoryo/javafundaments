import java.util.ArrayList;
import java.util.List;

public class VectorParser
{
    public static List<Integer> parseVector(String input)
    {
        List <Integer> vector = new ArrayList<Integer>();
        String[] parts = input.split("[^\\d-]+");

        for (String part : parts)
        {
            if (part.length() > 0)
            {
                vector.add(Integer.parseInt(part));
            }
        }
        
        return vector;
    }
}
