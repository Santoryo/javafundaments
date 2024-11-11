public class Person extends TelephoneEntry {
    private String name;
    private String surname;
    private Address address;

    public Person(String name, String surname, Address address, TelephoneNumber telephoneNumber)
    {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    @Override public String description()
    {
        return this.name + " " + this.surname + "\n" + this.address.toString() + "\n" + this.telephoneNumber.toString();
    }
}
