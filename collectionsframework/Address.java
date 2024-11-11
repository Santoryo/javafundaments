public class Address
{
    private String street;
    private String houseNumber;
    private String city;
    private String postalCode;
    private String country;

    public Address(String street, String houseNumber, String postalCode, String city, String country)
    {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override public String toString()
    {
        return street + " " + houseNumber + "\n" + postalCode + " " + city + "\n" + country;
    }
}