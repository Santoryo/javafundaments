import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map; 

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
        Iterator<Map.Entry<TelephoneNumber, TelephoneEntry>> iterator = this.treeMap.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<TelephoneNumber, TelephoneEntry> entry = iterator.next();
            System.out.println(entry.getValue().description() + "\n");
        }
    }
}
