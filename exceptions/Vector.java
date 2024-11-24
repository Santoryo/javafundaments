import java.util.ArrayList;
import java.util.List;

public class Vector {
    private final List<Integer> vector;

    public Vector(List<Integer> vector)
    {
        this.vector = vector;
    }

    public List<Integer> getVector()
    {
        return vector;
    }

    public Vector add(Vector other) throws DifferentVectorsLengthsException
    {
        List<Integer> result = new ArrayList<Integer>();

        if (vector.size() != other.getVector().size())
        {
            throw new DifferentVectorsLengthsException(vector.size(), other.getVector().size());
        }

        for (int i = 0; i < vector.size(); i++)
        {
            result.add(vector.get(i) + other.getVector().get(i));
        }

        return new Vector(result);
    }

    public static Vector fromString(String input)
    {
        List<Integer> elements = new ArrayList<>();
        String[] parts = input.split("[^\\d-]+"); // Split on non-numeric characters
        for (String part : parts)
        {
            if (part.length() > 0)
            {
                elements.add(Integer.parseInt(part));
            }
        }
        return new Vector(elements);
    }

    @Override
    public String toString()
    {
        return vector.toString();
    }
}
