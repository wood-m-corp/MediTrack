import java.time.LocalDate;
import java.util.*;

public interface DoctorMethodHolder {
    default void createOrEditMedicalChart() {
        String patientID = InputUtility.prompt("Enter patient ID: ");
        Patient patient = Registry.getPatientByID(patientID);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        MedicalChart Chart = patient.getChart();

        if (Chart == null) {
            Name name = patient.getName();
            int age = patient.getAge();
            LocalDate dob = patient.getDateOfBirth();

            List<String> medications = new ArrayList<>();
            medications.add(InputUtility.prompt("Enter medications: "));

            List<String> pastSurgeries = new ArrayList<>();
            pastSurgeries.add(InputUtility.prompt("Enter past surgeries: "));

            List<VisitNote> notes = new ArrayList<>();
            notes.add(new VisitNote(InputUtility.prompt("Enter notes from the visit: ")));

            Chart = new MedicalChart(name, age, dob, medications, pastSurgeries, notes);

            patient.setMedicalChart(Chart);

            System.out.println("Chart added to " + name.getFullName());
            System.out.println(Chart);

        } else {
            System.out.println("Updating existing medical chart for " + patient.getName().getFullName());

            String addMed = InputUtility.prompt("Enter new medication (or leave blank): ");
            if (!addMed.isBlank()) Chart.getMedications().add(addMed);

            String addSurgery = InputUtility.prompt("Enter new past surgery (or leave blank): ");
            if (!addSurgery.isBlank()) Chart.getPastSurgeries().add(addSurgery);

            String visitNote = InputUtility.prompt("Enter visit note: ");
            if (!visitNote.isBlank()) Chart.getNotes().add(new VisitNote(visitNote));

            System.out.println("Medical chart updated.");
        }

        System.out.println("\nCurrent Medical Chart:");
        System.out.println(Chart);
    }

    default void viewMedicalChart(String ID) {
        System.out.println(Registry.getPatientByID(ID).getChart());
    }
}
