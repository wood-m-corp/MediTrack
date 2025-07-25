import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public interface DoctorMethodHolder {
    default void createMedicalChart() {
        String patientID = InputUtility.prompt("Enter patient ID: ");
        Patient patient = Registry.getPatientByID(patientID);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        Name name = patient.getName();
        int age = patient.getAge();
        LocalDate dob = patient.getDateOfBirth();

        String medications = InputUtility.prompt("Enter medications (comma-separated): ");
        List<String> Medication = Arrays.stream(medications.split(",")).map(String::trim).collect(Collectors.toList());

        String pastSurgeries = InputUtility.prompt("Enter past surgeries: ");
        List<String> Surgeries = Arrays.stream(pastSurgeries.split(",")).map(String::trim).collect(Collectors.toList());

        String visitNotes = InputUtility.prompt("Enter notes from the visit: ");

        MedicalChart Chart = new MedicalChart(name, age, dob, Medication, Surgeries, visitNotes);

        patient.addMedicalChart(Chart);
        System.out.println("Chart added to " + name.getFullName());
        System.out.println(Chart);
    }

    default void viewMedicalChart(String ID) {
        System.out.println(Registry.getPatientByID(ID).getCharts());
    }
}
