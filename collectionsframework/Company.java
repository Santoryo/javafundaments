public class Company extends TelephoneEntry {
    private String name;
    private Address address;

    public Company(String name, Address address, TelephoneNumber telephoneNumber)
    {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    @Override public String description()
    {
        return this.name + "\n" + this.address.toString() + "\n" + this.telephoneNumber.toString();
    }
    
}
