public interface GlobalMethodHolder {
    default Person login(String ID, String lastName) {
        Person user = Registry.findByIdAndLastName(ID, lastName);
        if (user == null) {
            System.out.println("Login failed, user not found.");
            login(ID, lastName);
        } else {
            System.out.println("Welcome, " + user.getName().getFullName());
        }
        return user;
    }
}
