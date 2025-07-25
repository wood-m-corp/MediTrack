import java.time.LocalDate;

class Administrator extends Person implements UserCreator, ReceptionistMethodHolder, DoctorMethodHolder {

    public Administrator(String ID, Name name) {
        super(ID, name);
    }

    @Override
    public String getRole() { return "Administrator"; }

    @Override
    public Person create(String role, String ID, Name name, String specialty) {
        return UserCreator.super.create(role, ID, name, specialty);
    }

    @Override
    public Patient registerPatient() {
        return ReceptionistMethodHolder.super.registerPatient();
    }

    @Override
    public Appointment setAppointment() {
        return ReceptionistMethodHolder.super.setAppointment();
    }

    @Override
    public void viewAppointments(LocalDate date) {
        ReceptionistMethodHolder.super.viewAppointments(date);
    }

    @Override
    public void viewPatientInfo(String ID) {
        ReceptionistMethodHolder.super.viewPatientInfo(ID);
    }
}
