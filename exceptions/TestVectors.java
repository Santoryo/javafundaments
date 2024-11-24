import java.util.List;

public class TestVectors {
    public static void main(String[] args) {
        List<Integer> vector1 = VectorParser.parseVector("1,2,3,4,5");
        List<Integer> vector2 = VectorParser.parseVector("5,4,F,2,1,F");
        
        try
        {
            List<Integer> result = VectorAdder.addVectors(vector1, vector2);
            System.out.println(result);
        }
        catch (DifferentVectorsLengthsException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Vector 1 length: " + e.getVectorLength1());
            System.out.println("Vector 2 length: " + e.getVectorLength2());
        }
    }
}
