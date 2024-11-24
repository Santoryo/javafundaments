public class TestVectors
{
    public static void main(String[] args)
    {
        Vector v1 = Vector.fromString("1,2,3,         5");
        Vector v2 = Vector.fromString("4, 5, 6, 3734, F,ddasdas");
        try
        {
            Vector v3 = v1.add(v2);
            System.out.println(v3.toString());
        }
        catch (DifferentVectorsLengthsException e)
        {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Vector 1 length: " + e.getVectorLength1());
            System.out.println("Vector 2 length: " + e.getVectorLength2());
        }
    }
}
