import java.time.LocalDate;
import java.util.*;

public class MedicalChart {
    private Name patientName;
    private int patientAge;
    private LocalDate dateOfBirth;

    private List<String> medications;
    private List<String> pastSurgeries;
    private List<VisitNote> notes;

    public MedicalChart(Name patientName, int patientAge, LocalDate dateOfBirth,
                        List<String> medications,
                        List<String> pastSurgeries,
                        List<VisitNote> notes) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.dateOfBirth = dateOfBirth;
        this.medications = medications != null ? medications : new ArrayList<>();
        this.pastSurgeries = pastSurgeries != null ? pastSurgeries : new ArrayList<>();
        this.notes = notes != null ? notes : new ArrayList<>();
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void setPastSurgeries(List<String> pastSurgeries) {
        this.pastSurgeries = pastSurgeries;
    }

    public List<String> getMedications() {
        return medications;
    }

    public List<String> getPastSurgeries() {
        return pastSurgeries;
    }

    public List<VisitNote> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Medical Chart for " + patientName.getFullName() + "\n" +
                "Age: " + patientAge + "\n" +
                "DOB: " + dateOfBirth +  "\n" +
                "Medications: " + medications + "\n" +
                "Past Surgeries: " + pastSurgeries + "\n" +
                "Visit Notes:\n" + notesToString();
    }

    private  String notesToString() {
        StringBuilder sb = new StringBuilder();
        for (VisitNote note : notes) {
            sb.append(note.toString()).append("\n");
        }
        return sb.toString();
    }

}
