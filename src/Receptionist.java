import java.time.LocalDate;

class Receptionist extends Person implements ReceptionistMethodHolder {

    public Receptionist(String ID, Name name) {
        super(ID, name);
    }

    @Override
    public String getRole() { return "Receptionist"; }

    //Creates Patient object with constructor parameters, then sets the remaining fields not in the parameters
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
