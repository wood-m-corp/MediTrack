interface UserCreator {
    //Method to create a Person and auto set based on submitted role
    default Person create(String role, String ID, Name name, String specialty) {
        Person person = switch (role.toLowerCase()) {
            case "doctor" -> new Doctor(ID, name, specialty);
            case "administrator" -> new Administrator(ID, name);
            case "receptionist" -> new Receptionist(ID, name);
            default -> throw new IllegalArgumentException("Invalid role type");
        };

        //Adds created person to employee registry
        Registry.addUser(person);
        return person;
    }
}
