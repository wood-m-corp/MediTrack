public class ContactInfo {
    private String email;
    private String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() { return email; }
    public String getPhone() { return phone; }


    @Override
    public String toString() {
        return "Email: " + email + "\n" + "Phone: " + phone + "\n";
    }
}
