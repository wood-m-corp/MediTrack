import java.time.LocalDate;

class Doctor extends Person implements ReceptionistMethodHolder{
    private String specialty;

    public Doctor(String ID, Name name, String specialty) {
        super(ID, name);
        this.specialty = specialty;
    }

    @Override
    public String getRole() { return "Doctor"; }

    @Override
    public void Display(){
        super.Display();
        System.out.println("Specialty: " + specialty);
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
