public class Patient extends Person {
// Add other private variables, their setters, getters, and add parameters to constructor.
    // Deprecate contacts when Contacts class is available
    private String emailAddress;
    private String phoneNumber;
    private String SSN;

    //Personal information
    private String middleName;
    private String gender;
    private String maritalStatus;
    private String race;
    private String ethnicity;


    //Medical History
    private String currentMedConditions;
    private String currentMedications;
    private String allergies;
    private String pastSurgeries;

    public Patient(String ID, String firstName, String middleName, String lastName, String role) {
        setEmployeeID(ID);
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setRole(role);
    }

    //Setters
    public void setEmailAddress(String emailAddress){
        if (emailAddress != null) {
            this.emailAddress = emailAddress;
        } else {
            System.out.println("Invalid email address");
            System.exit(0);
        }
    }

    public void setPhoneNumber(String phoneNumber){
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number");
            System.exit(0);
        }
    }


    public void setSSN(String SSN){
        if (SSN != null) {
            this.SSN = SSN;
        } else {
            System.out.println("Invalid insurance provider");
            System.exit(0);
        }
    }

    public void setMiddleName(String middleName){
        if (middleName != null) {
            this.middleName = middleName;
        } else {
            System.out.println("Invalid middle name");
            System.exit(0);
        }
    }

    public void setGender(String gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            System.out.println("Invalid gender");
            System.exit(0);
        }
    }

    public void setMaritalStatus(String maritalStatus) {
        if (maritalStatus != null) {
            this.maritalStatus = maritalStatus;
        } else {
            System.out.println("Invalid marital status");
            System.exit(0);
        }
    }

    public void setRace(String race) {
        if (race != null) {
            this.race = race;
        } else {
            System.out.println("Invalid race");
            System.exit(0);
        }
    }

    public void setEthnicity(String ethnicity) {
        if (ethnicity != null) {
            this.ethnicity = ethnicity;
        } else {
            System.out.println("Invalid ethnicity");
            System.exit(0);
        }
    }

    public void setCurrentMedConditions(String currentMedConditions) {
        if (currentMedConditions != null) {
            this.currentMedConditions = currentMedConditions;
        } else {
            System.out.println("Invalid medical conditions");
            System.exit(0);
        }
    }

    public void setCurrentMedications(String currentMedications) {
        if (currentMedications != null) {
            this.currentMedications = currentMedications;
        } else {
            System.out.println("Invalid medical conditions");
            System.exit(0);
        }
    }

    public void setAllergies(String allergies) {
        if (allergies != null) {
            this.allergies = allergies;
        } else {
            System.out.println("Invalid allergies");
            System.exit(0);
        }
    }

    public void setPastSurgeries(String pastSurgeries) {
        if (pastSurgeries != null) {
            this.pastSurgeries = pastSurgeries;
        } else {
            System.out.println("Invalid past surgeries");
            System.exit(0);
        }
    }

    //Getters
    public String getEmailAddress() { return emailAddress; }
    public String getSSN() { return SSN; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getMiddleName() { return middleName; }
    public String getGender() { return gender; }
    public String getMaritalStatus() { return maritalStatus; }
    public String getRace() { return race; }
    public String getEthnicity() { return ethnicity; }
    public String getCurrentMedConditions() { return currentMedConditions; }
    public String getCurrentMedications() { return currentMedications; }
    public String getAllergies() { return allergies; }
    public String getPastSurgeries() { return pastSurgeries; }

    //Todo Add a Display() function
}
