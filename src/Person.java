abstract class Person {
    protected String ID;
    protected Name name;

    public Person(String ID, Name name) {
        if (ID == null || ID.isBlank()) throw new IllegalArgumentException("Invalid ID");
        this.ID = ID;
        this.name = name;
    }

    public abstract String getRole();
    public String getID() {return ID; }
    public Name getName() {return name; }

    public void Display() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Role: " + getRole());
    }
}
