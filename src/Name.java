public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = validate(firstName, "First Name");
        this.middleName = middleName != null ? middleName : "";
        this.lastName = validate(lastName, "Last Name");
    }

    //Ensure that name fields are valid
    private String validate(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or blank");
        }
        return value;
    }

    public String getFullName() {
        //Returns firstName, space if no middleName, and lastName
        return firstName + (middleName.isEmpty() ? " " : " " + middleName + " ") + lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
