public class Person {
    protected String employeeID;
    protected String firstName;
    protected String lastName;
    protected String role;
    protected String specialty;

    public Person() {

    }

    // Setters
    public void setEmployeeID(String employeeID) {
        if (employeeID != null) {
            this.employeeID = employeeID;
        } else {
            System.out.println("Invalid Employee ID");
            System.exit(0);
        }
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        } else {
            System.out.println("Invalid first name.");
            System.exit(0);
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            System.out.println("Invalid last name.");
            System.exit(0);
        }
    }

    public void setRole(String role) {
        if (role != null){
            this.role = role;
        } else {
            System.out.println("Invalid role");
            System.exit(0);
        }
    }

    public void setSpecialty(String specialty) {
        if (specialty != null) {
            this.specialty = specialty;
        } else {
            System.out.println("Invalid specialty");
            System.exit(0);
        }
    }

    // Getters
    public String getEmployeeID() { return employeeID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getRole() { return role; }
    public String getSpecialty() { return specialty; }
}
