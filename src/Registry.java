import java.util.ArrayList;
import java.util.List;

public class Registry {
    private static final List<Person> allUsers = new ArrayList<>();

    public static void addUser(Person person) {
        allUsers.add(person);
    }

    public static List<Person> getAllUsers() { return allUsers; }


    public static Person findIdAndLastName(String ID, String lastName) {
        for (Person user : allUsers) {
            if (user.getID().equalsIgnoreCase(ID) && user.getName().getLastName().equalsIgnoreCase(lastName)) {
                return user;
            }
        }
        return null;
    }
}
