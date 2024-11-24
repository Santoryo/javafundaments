import java.util.ArrayList;
import java.util.List;

public class VectorAdder 
{
    public static List<Integer> addVectors(List<Integer> vector1, List<Integer> vector2) throws DifferentVectorsLengthsException
    {
        List<Integer> result = new ArrayList<Integer>();
        
        if (vector1.size() != vector2.size())
        {
            throw new DifferentVectorsLengthsException(vector1.size(), vector2.size());
        }

        for (int i = 0; i < vector1.size(); i++)
        {
            result.add(vector1.get(i) + vector2.get(i));
        }

        return result;
    }
}
