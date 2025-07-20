import javax.print.Doc;

public class Administrator extends Person {

    public Administrator(String ID, String firstName, String lastName, String role) {
        setEmployeeID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setRole(role);
    }

    public void createAccount() {
        //Enter ID
        //Enter role
        //Enter names
        //If role is doctor, enter specialty
        System.out.println("Enter role");
        setRole(role);
        if (getRole().equals("Doctor")) {
            System.out.println("Enter ID");
            setEmployeeID(employeeID);
            System.out.println("Enter Doctor's specialty");
            setSpecialty(specialty);
            System.out.println("Enter first name of the Doctor");
            setFirstName(firstName);
            System.out.println("Enter last name of the Doctor");
            setLastName(lastName);

            Doctor newDoctor = new Doctor(employeeID, firstName, lastName, role, specialty);
        }

        else if (getRole().equals("Receptionist")) {
            System.out.println("Enter ID");
            setEmployeeID(employeeID);
            System.out.println("Enter first name of the Receptionist");
            setFirstName(firstName);
            System.out.println("Enter last name of the Receptionist");
            setLastName(lastName);

            Receptionist newReceptionist = new Receptionist(employeeID, firstName, lastName, role);
        }

        else if (getRole().equals("Administrator")) {
            System.out.println("Enter ID");
            setEmployeeID(employeeID);
            System.out.println("Enter first name of the Administrator");
            setFirstName(firstName);
            System.out.println("Enter last name of the Administrator");
            setLastName(lastName);

            Administrator newAdministrator = new Administrator(employeeID, firstName, lastName, role);
        }

        else {
            System.out.println("Invalid role... Enter 'Administrator', 'Doctor', or 'Receptionist'.");
            createAccount();
        }
    }

    /*Display the Administrator as:
     * Employee ID: R001
     * Role: Administrator
     * Name: John Doe
     * */

    public void Display(){
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Role: " + getRole());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
    }
}
