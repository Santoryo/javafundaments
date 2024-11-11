public class Address
{
    private String street;
    private String houseNumber;
    private String city;
    private String postalCode;
    private String country;

    public Address(String street, String houseNumber, String postalCode, String city, String country)
    {
        if(street == null || postalCode == null || city == null || country == null)
        {
            throw new IllegalArgumentException();
        }

        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override public String toString()
    {
        return (this.street + " " + this.houseNumber + "\n" + this.postalCode + ", " + this.city + "\n" + country).replaceAll("null", "");
    }
}