public class TelephoneNumber implements Comparable<TelephoneNumber>
{
    private String countryCode;
    private String localNumber;

    public TelephoneNumber(String countryCode, String localNumber)
    {
        this.countryCode = countryCode;
        this.localNumber = localNumber;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getLocalNumber()
    {
        return localNumber;
    }

    @Override public int compareTo(TelephoneNumber otherNumber)
    {
        if (this.countryCode.equals(otherNumber.countryCode))
        {
            return this.localNumber.compareTo(otherNumber.localNumber);
        }
        else
        {
            return this.countryCode.compareTo(otherNumber.countryCode);
        }
    }

    @Override public String toString()
    {
        return "+" + this.countryCode + " " + this.localNumber;
    }
} 