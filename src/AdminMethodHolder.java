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
}
