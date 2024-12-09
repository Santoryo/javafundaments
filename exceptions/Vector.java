import java.util.ArrayList;
import java.util.List;

public class Vector
{
    private final List<Integer> vector;

    public Vector(List<Integer> vector)
    {
        this.vector = vector;
    }

    public List<Integer> getVector()
    {
        return this.vector;
    }

    public Vector add(ArrayList<Vector> others) throws DifferentVectorsLengthsException
    {
        List<Integer> result = new ArrayList<>(vector);
        int[] lengths = new int[others.size() + 1];

        lengths[0] = vector.size();

        for (int i = 0; i < others.size(); i++)
        {
            lengths[i + 1] = others.get(i).getVector().size();
        }

        for (Vector other : others)
        {
            if (vector.size() != other.getVector().size())
            {
                throw new DifferentVectorsLengthsException(lengths, "Couldn't add vectors");
            }

            for (int i = 0; i < vector.size(); i++)
            {
                result.set(i, result.get(i) + other.getVector().get(i));
            }
        }

        return new Vector(result);
    }

    public static Vector fromString(String input)
    {
        List<Integer> elements = new ArrayList<>();
        String[] parts = input.split("[^\\d-]+");
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
