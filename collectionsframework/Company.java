public class Company extends TelephoneEntry
{
    private String name;
    private Address address;

    public Company(String name, Address address, TelephoneNumber telephoneNumber)
    {
        if(name == null)
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    @Override public String description()
    {
        return this.telephoneNumber.toString() + "\n" + this.name + "\n" + this.address.toString();
    }
    
}
