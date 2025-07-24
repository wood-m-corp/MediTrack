class Patient {
// Add other private variables, their setters, getters, and add parameters to constructor.
    // Deprecate contacts when Contacts class is available
    private String ID;
    private ContactInfo contact;
    private Name name;
    private String SSN;

    //Personal information - Can be filled in later
    private String gender;
    private String maritalStatus;
    private String race;
    private String ethnicity;


    //Medical History
    private String currentMedConditions;
    private String currentMedications;
    private String allergies;
    private String pastSurgeries;

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

    public void setRace(String race) {
        this.race = race;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void setCurrentMedConditions(String currentMedConditions) {
        this.currentMedConditions = currentMedConditions;
    }

    public void setCurrentMedications(String currentMedications) {
        this.currentMedications = currentMedications;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setPastSurgeries(String pastSurgeries) {
        this.pastSurgeries = pastSurgeries;
    }

    //Getters
    public String getID() { return ID; }
    public Name getName() { return name; }
    public String getSSN() { return SSN; }
    public String getGender() { return gender; }
    public String getMaritalStatus() { return maritalStatus; }
    public String getRace() { return race; }
    public String getEthnicity() { return ethnicity; }
    public String getCurrentMedConditions() { return currentMedConditions; }
    public String getCurrentMedications() { return currentMedications; }
    public String getAllergies() { return allergies; }
    public String getPastSurgeries() { return pastSurgeries; }

    public void Display(){
        System.out.println("Patient ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contact);
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
