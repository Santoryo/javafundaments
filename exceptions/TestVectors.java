import java.util.ArrayList;

public class TestVectors
{
    public static ArrayList<Vector> vectors;
    public static Vector result;

    public static void main(String[] args) {
        vectors = new ArrayList<Vector>();
        while (true)
        {
            UserInput userInput = new UserInput();
            System.out.println("Enter the vector or 's' to sum the vectors: ");
            String input = userInput.getUserInput();

            if (input.equals("s"))
            {
                boolean shouldEnd = canSum();
                if (shouldEnd == true)
                {
                    break;
                }
                else
                {
                    vectors = new ArrayList<Vector>();
                    continue;
                }
            }


            Vector vector = Vector.fromString(input);
            vectors.add(vector);
        }
    }

    static boolean canSum()
    {
        try
        {
            result = result.add(vectors);
        }
        catch (DifferentVectorsLengthsException e)
        {
            System.out.println(e.getMessage());

            System.out.print("Vector lengths: ");
            for(int length : e.getVectorLengths())
            {
                System.out.print(length + " ");
            }
            System.out.println();
            return false;
        }

        System.out.println("Added vector is: " + result.toString());
        return true;
    }
}
