public class Person extends TelephoneEntry
{
    private String name;
    private String surname;
    private Address address;

    public Person(String name, String surname, Address address, TelephoneNumber telephoneNumber)
    {
        if(name == null || surname == null || telephoneNumber == null)
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    @Override public String description()
    {
        return this.telephoneNumber.toString() + "\n" + this.name + " " + this.surname + "\n" + this.address.toString();
    }
}
