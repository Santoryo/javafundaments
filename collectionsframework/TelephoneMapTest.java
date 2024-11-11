public class TelephoneMapTest {
    public static void main(String[] args) {
        TelephoneMap telephoneMap = new TelephoneMap();
        telephoneMap.addPerson("Leo", "Ryba", "Zielona 15", "1", "90123", "Lodz", "Poland", "48", "987654321");
        telephoneMap.addPerson("John", "Doe", "Main Street", null, "12345", "New York", "USA", "1", "123456789");
        telephoneMap.addCompany("Google", "1600 Mountain View", null, "54321", "California", "USA", "1", "987654321");
        telephoneMap.print();
    }

}
