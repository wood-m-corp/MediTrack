public class Doctor extends Person {

    public Doctor(String ID, String firstName, String lastName, String role, String specialty) {
        setEmployeeID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setRole(role);
    }

    /*Display the doctor as:
    * Employee ID: D001
    * Role: Doctor
    * Name: John Doe
    * Specialty: None
    * */

    public void Display(){
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Role: " + getRole());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Specialty: " + getSpecialty());
    }
}
