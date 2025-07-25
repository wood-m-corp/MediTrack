import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface AdminMethodHolder {
    default void archivePatientData(String fileName) {
        List<Patient> patients = Registry.getAllPatients();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Patient patient : patients) {
                writer.write(patient.toString());
                writer.newLine();
                writer.write("---------------------------------");
                writer.newLine();
            }
            System.out.println("Patients archived to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    default void editAccount() {
        String ID = InputUtility.prompt("Enter ID: ");
        Person user = Registry.findByID(ID);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Edit name for user: " + user.getName().getFullName());

        String newFirst = InputUtility.prompt("Enter new first name: ");
        String newMiddle = InputUtility.prompt("Enter new middle name: ");
        String newLast = InputUtility.prompt("Enter new last name: ");

        Name newName = new Name(newFirst, newMiddle, newLast);
        user.setName(newName);

        System.out.println("User name successfully updated to: " + user.getName().getFullName());
    }

    default void deleteAccount() {
        String ID = InputUtility.prompt("Enter ID: ");
        Person user = Registry.findByID(ID);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        String confirmation = InputUtility.prompt("Are you sure you wat to delete " + ID + " ? (Enter Yes/No)...");
        if(confirmation.equalsIgnoreCase("yes")) {
            Registry.removeUser(user);
        } else {
            System.out.println("User not deleted.");
        }
    }
}
