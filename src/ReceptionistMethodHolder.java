import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public interface ReceptionistMethodHolder {
    // These lists store patients and appointments for lookup and viewing objects within the lists
    List<Patient> listOfPatients = new ArrayList<>();
    Map<String, Patient> patientByID = new HashMap<>();
    List<Appointment> listOfAppointments = new ArrayList<>();

    //Takes input to create patient object with parameters and other fields.
    default Patient registerPatient() {
        String ID = InputUtility.prompt("Enter ID: ");

        String firstName = InputUtility.prompt("Enter First Name: ");
        String middleName = InputUtility.prompt("Enter Middle Name: ");
        String lastName = InputUtility.prompt("Enter Last Name: ");
        Name name = new Name(firstName, middleName, lastName);

        String email = InputUtility.prompt("Enter Email: ");
        String phone = InputUtility.prompt("Enter Phone: ");
        ContactInfo contact = new ContactInfo(email, phone);

        String gender = InputUtility.prompt("Enter Gender: ");
        String ssn = InputUtility.prompt("Enter SSN: ");

        Patient patient = new Patient(ID, name, ssn);

        // Additional personal details
        String maritalStatus = InputUtility.prompt("Enter Marital Status: ");
        patient.setMaritalStatus(maritalStatus);

        String race = InputUtility.prompt("Enter Race: ");
        patient.setRace(race);

        String ethnicity = InputUtility.prompt("Enter Ethnicity: ");
        patient.setEthnicity(ethnicity);

        // Medical history
        String medConditions = InputUtility.prompt("Enter Current Medical Conditions: ");
        patient.setCurrentMedConditions(medConditions);

        String medications = InputUtility.prompt("Enter Current Medications: ");
        patient.setCurrentMedications(medications);

        String allergies = InputUtility.prompt("Enter Allergies: ");
        patient.setAllergies(allergies);

        String pastSurgeries = InputUtility.prompt("Enter Past Surgeries: ");
        patient.setPastSurgeries(pastSurgeries);

        System.out.println(patient);
        listOfPatients.add(patient);
        patientByID.put(patient.getID(), patient);
        return patient;

        //Save to DB
    }

    default Appointment setAppointment() {
        System.out.println("=== Patient Information ===");
        String pID = InputUtility.prompt("Enter Patient ID: ");
        String pFirst = InputUtility.prompt("Enter Patient First Name: ");
        String pMiddle = InputUtility.prompt("Enter Patient Middle Name: ");
        String pLast = InputUtility.prompt("Enter Patient Last Name: ");
        Name pName = new Name(pFirst, pMiddle, pLast);

        String pEmail = InputUtility.prompt("Enter Patient Email: ");
        String pPhone = InputUtility.prompt("Enter Patient Phone: ");
        ContactInfo pContact = new ContactInfo(pEmail, pPhone);
        String pGender = InputUtility.prompt("Enter Patient Gender: ");
        String pSSN = InputUtility.prompt("Enter Patient SSN: ");

        Patient patient = new Patient(pID, pName, pSSN);

        // Prompt for Doctor Info
        System.out.println("=== Doctor Information ===");
        String dID = InputUtility.prompt("Enter Doctor ID: ");
        String dFirst = InputUtility.prompt("Enter Doctor First Name: ");
        String dMiddle = InputUtility.prompt("Enter Doctor Middle Name: ");
        String dLast = InputUtility.prompt("Enter Doctor Last Name: ");
        Name dName = new Name(dFirst, dMiddle, dLast);
        String specialty = InputUtility.prompt("Enter Specialty: ");

        Doctor doctor = new Doctor(dID, dName, specialty);

        // Prompt for DateTime
        System.out.println("=== Appointment Date and Time ===");
        LocalDateTime dateTime = null;
        while (dateTime == null) {
            String dateTimeStr = InputUtility.prompt("Enter date and time (yyyy-MM-dd HH:mm): ");
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please try again.");
            }
        }

        Appointment appointment = new Appointment(patient, doctor, dateTime);
        listOfAppointments.add(appointment);

        System.out.println("Appointment has been made.");
        appointment.Display();
        return appointment;
    }

    default void viewAppointments(LocalDate date) {
        System.out.println("Appointments on " + date + ":");
        boolean found = false;
        for (Appointment appt : listOfAppointments) {
            if(appt.getDateTime().toLocalDate().equals(date)) {
                appt.Display();
                System.out.println("----------------------");
                found = true;
            }
        }
        if(!found) {
            System.out.println("No appointments scheduled for this date.");
        }
    }

    default void viewPatientInfo(String ID) {
        Patient foundPatient = patientByID.get(InputUtility.prompt("Enter ID: "));

        if (foundPatient != null) {
            System.out.println("Patient found: ");
            foundPatient.Display();
        } else {
            System.out.println("Patient ID not found.");
        }
    }

}
