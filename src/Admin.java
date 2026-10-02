public class Admin extends User {

    public Admin(int userId, String name, String email,
                 String password, String phone) {

        super(userId, name, email, password, phone);
    }

    @Override
    public void showDashboard() {

        System.out.println("\n===== ADMIN DASHBOARD =====");
        System.out.println("Welcome Admin, " + getName());
        System.out.println("Email: " + getEmail());
    }
}