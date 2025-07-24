import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime dateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    /*Display Appointment as:
    * John Doe has an appointment with Dr. John Doe.
    * When: yyyy-MM-dd HH:mm:ss
    * */
    public void Display(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(patient.getName().getFullName() + " has an appointment with Dr. " +
                doctor.getName().getFullName() + ".");
        System.out.println("When: " + dateTime.format(formatter));
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
