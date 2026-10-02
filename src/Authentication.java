import java.util.ArrayList;
import java.util.Scanner;

public class Authentication {

    private ArrayList<User> users = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private int nextUserId = 1;

    // Registration

    public void register() {

        System.out.println("\n===== USER REGISTRATION =====");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        // Check duplicate email

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {

                System.out.println("Email already registered!");
                return;
            }
        }

        Passenger passenger = new Passenger(
                nextUserId,
                name,
                email,
                password,
                phone
        );

        users.add(passenger);

        System.out.println("\nRegistration Successful!");
        System.out.println("Your User ID is: " + nextUserId);

        nextUserId++;
    }

    // Login

    public User login() {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)
                    && user.getPassword().equals(password)) {

                System.out.println("\nLogin Successful!");

                return user;
            }
        }

        System.out.println("\nInvalid email or password.");

        return null;
    }

    public void showUsers() {

        System.out.println("\n===== REGISTERED USERS =====");

        for (User user : users) {

            System.out.println(
                    user.getUserId() + " - " +
                    user.getName() + " - " +
                    user.getEmail()
            );
        }
    }
}