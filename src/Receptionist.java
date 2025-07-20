public class Receptionist extends Person {

    public Receptionist(String ID, String firstName, String lastName, String role) {
        setEmployeeID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setRole(role);
    }

    /*Display the Receptionist as:
     * Employee ID: R001
     * Role: Receptionist
     * Name: John Doe
     * */

    public void Display(){
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Role: " + getRole());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
    }
}
