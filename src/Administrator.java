import java.time.LocalDate;

class Administrator extends Person implements UserCreator, AdminMethodHolder, ReceptionistMethodHolder, DoctorMethodHolder {

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

    @Override
    public void createOrEditMedicalChart() {
        DoctorMethodHolder.super.createOrEditMedicalChart();
    }

    @Override
    public void viewMedicalChart(String ID) {
        DoctorMethodHolder.super.viewMedicalChart(ID);
    }

    @Override
    public void archivePatientData(String fileName) {
        AdminMethodHolder.super.archivePatientData(fileName);
    }

    @Override
    public void editAccount() {
        AdminMethodHolder.super.editAccount();
    }

    @Override
    public void deleteAccount() {
        AdminMethodHolder.super.deleteAccount();
    }
}
