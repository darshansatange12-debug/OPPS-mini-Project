public class Passenger extends User {

    public Passenger(int userId, String name, String email,
                     String password, String phone) {

        super(userId, name, email, password, phone);
    }

    @Override
    public void showDashboard() {

        System.out.println("\n===== PASSENGER DASHBOARD =====");
        System.out.println("Welcome, " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
    }
}