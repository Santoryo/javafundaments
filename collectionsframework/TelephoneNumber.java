public class TelephoneNumber implements Comparable<TelephoneNumber>
{
    private int countryCode;
    private String localNumber;

    public TelephoneNumber(int countryCode, String localNumber)
    {
        if(localNumber == null || countryCode < 0)
        {
            throw new IllegalArgumentException();
        }

        this.countryCode = countryCode;
        this.localNumber = localNumber;
    }

    @Override
    public int compareTo(TelephoneNumber other)
    {
        if(this.countryCode == other.countryCode)
        {
            return this.localNumber.compareTo(other.localNumber);
        }
        return this.countryCode - other.countryCode;
    }

    @Override
    public String toString()
    {
        return "+" + this.countryCode + " " + this.localNumber;
    }
} 