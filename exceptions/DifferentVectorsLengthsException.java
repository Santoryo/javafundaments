class DifferentVectorsLengthsException extends Exception
{
    private final int[] vectorLengths;
    
    public DifferentVectorsLengthsException(int[] vectorLengths, String errorMessage)
    {
        super(errorMessage);
        this.vectorLengths = vectorLengths;
    }

    public int[] getVectorLengths()
    {
        return vectorLengths;
    }
}