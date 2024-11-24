class DifferentVectorsLengthsException extends Exception
{
    private final int vectorLength1;
    private final int vectorLength2;
    public DifferentVectorsLengthsException(int vectorLength1, int vectorLength2)
    {
        super("Vectors must have the same length");
        this.vectorLength1 = vectorLength1;
        this.vectorLength2 = vectorLength2;
    }

    public int getVectorLength1()
    {
        return vectorLength1;
    }

    public int getVectorLength2()
    {
        return vectorLength2;
    }
}