import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MedicalChart {
    private Name patientName;
    private int patientAge;
    private LocalDate dateOfBirth;

    private List<String> medications;
    private List<String> pastSurgeries;
    private String visitNotes;

    public MedicalChart(Name patientName, int patientAge, LocalDate dateOfBirth, List<String> medications,
                        List<String> pastSurgeries, String visitNotes) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.dateOfBirth = dateOfBirth;
        this.medications = medications;
        this.pastSurgeries = pastSurgeries;
        this.visitNotes = visitNotes;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void setPastSurgeries(List<String> pastSurgeries) {
        this.pastSurgeries = pastSurgeries;
    }

    public void addMedications(String medications) { this.medications.add(medications); }
    public void addPastSurgeries(String pastSurgeries) { this.pastSurgeries.add(pastSurgeries); }
    public void setVisitNotes(String visitNotes) { this.visitNotes = visitNotes; }
    public Name getPatientName() { return patientName; }
    public int getPatientAge() { return patientAge; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public List<String> getMedications() { return medications; }
    public List<String> getPastSurgeries() { return pastSurgeries; }
    public String getVisitNotes() { return visitNotes; }

    public void editMedicalChart(){

    }

    @Override
    public String toString() {
        return "Medical Chart for " + patientName.getFullName() +
                " (DOB: " + dateOfBirth + ", Age: " + patientAge + ")\n" +
                "Medications: " + medications + "\n" +
                "Past Surgeries: " + pastSurgeries + "\n" +
                "Visit Notes: " + visitNotes;
    }
}
