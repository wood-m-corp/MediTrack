import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registry {
    private static final List<Person> allUsers = new ArrayList<>();
    private static final Map<String, Patient> patientMap = new HashMap<>();

    public static void addUser(Person person) {
        allUsers.add(person);
    }

    public static List<Person> getAllUsers() { return allUsers; }


    public static Person findByIdAndLastName(String ID, String lastName) {
        for (Person user : allUsers) {
            if (user.getID().equalsIgnoreCase(ID) && user.getName().getLastName().equalsIgnoreCase(lastName)) {
                return user;
            }
        }
        return null;
    }

    public static void addPatient(Patient patient) {
        patientMap.put(patient.getID(), patient);
    }

    //Find patient using their ID
    public static Patient getPatientByID(String ID) {
        return patientMap.get(ID);
    }

    //Find patient using their last name
    public static List<Patient> searchPatientsByLastName(String lastName) {
        List<Patient> results = new ArrayList<>();
        for (Patient patient : patientMap.values()) {
            if (patient.getName().getLastName().equalsIgnoreCase(lastName)) {
                results.add(patient);
            }
        }
        return results;
    }

    //Return all patients on the list
    public static List<Patient> getAllPatients() {
        return new ArrayList<>(patientMap.values());
    }
}
