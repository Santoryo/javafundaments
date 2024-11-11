import java.util.TreeMap;

public class TelephoneMap {
    private TreeMap<TelephoneNumber, TelephoneEntry> treeMap;

    public TelephoneMap()
    {
        this.treeMap = new TreeMap<>();
    }

    public Person addPerson(String name, String surname, String street, String houseNumber, String postalCode, String city, String country, int countryCode, String number)
    {
        Address address = new Address(street, houseNumber, postalCode, city, country);
        TelephoneNumber telephoneNumber = new TelephoneNumber(countryCode, number);
        Person person = new Person(name, surname, address, telephoneNumber);
        this.treeMap.put(telephoneNumber, person);
        return person;
    }

    public Company addCompany(String name, String street, String houseNumber, String postalCode, String city, String country, int countryCode, String number)
    {
        Address address = new Address(street, houseNumber, postalCode, city, country);
        TelephoneNumber telephoneNumber = new TelephoneNumber(countryCode, number);
        Company company = new Company(name, address, telephoneNumber);
        this.treeMap.put(telephoneNumber, company);
        return company;
    }

    public void print()
    {
        for (TelephoneEntry entry : this.treeMap.values())
        {
            System.out.println(entry.description());
            System.out.println();
        }
    }
}
