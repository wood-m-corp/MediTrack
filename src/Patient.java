import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


class Patient {
// Add other private variables, their setters, getters, and add parameters to constructor.
    private String ID;
    private ContactInfo contact;
    private Name name;
    private String SSN;

    //Personal information - Can be filled in later
    private String gender;
    private String maritalStatus;
    private String race;
    private String ethnicity;
    private int age;
    private LocalDate dateOfBirth;


    //Medical History
    private List<String> currentMedConditions = new ArrayList<>();
    private List<String> currentMedications = new ArrayList<>();
    private List<String> allergies = new ArrayList<>();
    private List<String> pastSurgeries = new ArrayList<>();

    //Medical Chart
    private List<MedicalChart> charts = new ArrayList<>();

    public Patient(String ID, Name name, String SSN) {
        this.ID = ID;
        this.name = name;
        this.SSN = SSN;
    }

    //Setters
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void  setID(String ID) {
        this.ID = ID;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public void setDateOfBirth (LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void addCurrentMedConditions(String currentMedConditions) {
        this.currentMedConditions.add(currentMedConditions);
    }

    public void addCurrentMedications(String currentMedications) {
        this.currentMedications.add(currentMedications);
    }

    public void addAllergies(String allergies) {
        this.allergies.add(allergies);
    }

    public void addPastSurgeries(String pastSurgeries) {
        this.pastSurgeries.add(pastSurgeries);
    }

    public void addMedicalChart(MedicalChart Chart) {
        charts.add(Chart);
    }

    //Getters
    public String getID() { return ID; }
    public Name getName() { return name; }
    public String getSSN() { return SSN; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getMaritalStatus() { return maritalStatus; }
    public String getRace() { return race; }
    public String getEthnicity() { return ethnicity; }
    public List<String> getCurrentMedConditions() { return currentMedConditions; }
    public List<String> getCurrentMedications() { return currentMedications; }
    public List<String> getAllergies() { return allergies; }
    public List<String> getPastSurgeries() { return pastSurgeries; }
    public List<MedicalChart> getCharts() { return charts; }

    public void Display(){
        System.out.println("Patient ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contact);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("SSN: " + SSN);
        System.out.println("Marital Status: " + maritalStatus);
        System.out.println("Race: " + race);
        System.out.println("Ethnicity: " + ethnicity);
        System.out.println("Current Medical Conditions: " + currentMedConditions);
        System.out.println("Current Medications: " + currentMedications);
        System.out.println("Allergies: " + allergies);
        System.out.println("Past Surgeries: " + pastSurgeries);
    }

    @Override
    public String toString() {
        return "Patient ID: " + ID + "\n"
                + "Name: " + name.getFullName() + "\n"
                + "Email: " + contact.getEmail() + "\n"
                + "Phone: " + contact.getPhone() + "\n"
                + "Gender: " + gender + "\n"
                + "SSN: " + SSN + "\n"
                + "Marital Status: " + maritalStatus + "\n"
                + "Race: " + race + "\n"
                + "Ethnicity: " + ethnicity + "\n"
                + "Current Medical Conditions: " + currentMedConditions + "\n"
                + "Current Medications: " + currentMedications + "\n"
                + "Allergies: " + allergies + "\n"
                + "Past Surgeries: " + pastSurgeries;
    }
}
