import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Medical Office System ===");

        // Preload some sample users
        Registry.addUser(new Administrator("A001", new Name("Alice", "", "Admin")));

        while (true) {
            System.out.println("\n--- LOGIN ---");
            String ID = InputUtility.prompt("Enter your ID (or type 'exit' to quit): ");
            if(ID.equalsIgnoreCase("exit")) {
                System.out.println("Exiting system...");
                System.exit(0);
            }
            String lastName = InputUtility.prompt("Enter your last name: ");

            Person user = Registry.findByIdAndLastName(ID, lastName);

            if (user == null) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.println("Welcome, " + user.getName().getFullName() + "!");

            switch (user.getRole().toLowerCase()) {
                case "administrator" -> adminMenu((Administrator) user);
                case "doctor" -> doctorMenu((Doctor) user);
                case "receptionist" -> receptionistMenu((Receptionist) user);
                default -> System.out.println("Unknown role.");
            }
        }
    }

    private static void adminMenu(Administrator admin) {
        while (true) {
            System.out.println("""
                \n--- Administrator Menu ---
                1. Register a new user
                2. Archive all patients
                3. Edit user account name
                4. Remove user
                5. Logout
            """);

            int choice = InputUtility.promptInt("Select option: ");

            switch (choice) {
                case 1 -> {
                    String role = InputUtility.prompt("Enter role (Administrator, Doctor, or Receptionist): ");
                    if (!(role.equalsIgnoreCase("administrator")) &&
                        !(role.equalsIgnoreCase("doctor")) &&
                        !(role.equalsIgnoreCase("receptionist"))) {
                        System.out.println("Please enter a valid role (Administrator, Doctor, or Receptionist): ");
                        return;
                    }
                    String ID = InputUtility.prompt("Enter new ID for user: ");
                    String pFirst = InputUtility.prompt("Enter Patient First Name: ");
                    String pMiddle = InputUtility.prompt("Enter Patient Middle Name: ");
                    String pLast = InputUtility.prompt("Enter Patient Last Name: ");
                    Name name = new Name(pFirst, pMiddle, pLast);
                    String specialty = InputUtility.prompt("Enter specialty (Leave blank if user is not a doctor): ");
                    admin.create(role, ID, name, specialty);
                }
                case 2 -> {
                    admin.archivePatientData("Patient Data Export");
                    waitForUser();
                }
                case 3 -> {
                    admin.editAccount();
                    waitForUser();
                }
                case 4 -> {
                    admin.deleteAccount();
                    waitForUser();
                }
                case 5 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void doctorMenu(Doctor doctor) {
        while (true) {
            System.out.println("""
                \n--- Doctor Menu ---
                1. View Patient Chart
                2. Create/Update Medical Chart
                3. Logout
            """);

            int choice = InputUtility.promptInt("Select option: ");

            switch (choice) {
                case 1 -> {
                    String patientID = InputUtility.prompt("Enter Patent ID to view medical chart: ");
                    doctor.viewMedicalChart(patientID);
                    waitForUser();
                }
                case 2 -> {
                    doctor.createOrEditMedicalChart();
                    waitForUser();
                }
                case 3 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void receptionistMenu(Receptionist receptionist) {
        while (true) {
            System.out.println("""
                \n--- Receptionist Menu ---
                1. Register new patient
                2. Set appointment
                3. View appointments by date
                4. Logout
            """);

            int choice = InputUtility.promptInt("Select option: ");

            switch (choice) {
                case 1 -> {
                    receptionist.registerPatient();
                    waitForUser();
                }
                case 2 -> {
                    receptionist.setAppointment();
                    waitForUser();
                }
                case 3 -> {
                    LocalDate date = InputUtility.promptDate("Enter date to view appointments (yyyy-MM-dd): ");
                    receptionist.viewAppointments(date);
                    waitForUser();
                }
                case 4 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // Utility to pause before returning to the menu
    private static void waitForUser() {
        InputUtility.prompt("\nPress Enter to return to the menu...");
    }
}
