import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Authentication authentication = new Authentication();

        BusPassManager busPassManager = new BusPassManager();

        User loggedInUser = null;

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" ONLINE BUS PASS MANAGEMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    authentication.register();

                    break;

                case 2:

                    loggedInUser = authentication.login();

                    if (loggedInUser != null) {

                        if (loggedInUser instanceof Passenger) {

                            passengerMenu(
                                    loggedInUser,
                                    busPassManager,
                                    scanner
                            );

                        } else if (loggedInUser instanceof Admin) {

                            adminMenu(
                                    loggedInUser,
                                    busPassManager,
                                    scanner
                            );
                        }
                    }

                    break;

                case 3:

                    System.out.println("Thank you for using the system.");

                    scanner.close();

                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }

    // Passenger menu

    public static void passengerMenu(
            User user,
            BusPassManager busPassManager,
            Scanner scanner) {

        while (true) {

            System.out.println("\n===== PASSENGER MENU =====");

            System.out.println("1. View Profile");
            System.out.println("2. Apply Bus Pass");
            System.out.println("3. View My Passes");
            System.out.println("4. Logout");

            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    user.showDashboard();

                    break;

                case 2:

                    busPassManager.applyPass(user);

                    break;

                case 3:

                    busPassManager.viewMyPasses(user);

                    break;

                case 4:

                    System.out.println("Logged out successfully.");

                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }

    // Admin menu

    public static void adminMenu(
            User user,
            BusPassManager busPassManager,
            Scanner scanner) {

        while (true) {

            System.out.println("\n===== ADMIN MENU =====");

            System.out.println("1. View Dashboard");
            System.out.println("2. View All Passes");
            System.out.println("3. Approve Pass");
            System.out.println("4. Reject Pass");
            System.out.println("5. Logout");

            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    user.showDashboard();

                    break;

                case 2:

                    busPassManager.viewAllPasses();

                    break;

                case 3:

                    busPassManager.approvePass();

                    break;

                case 4:

                    busPassManager.rejectPass();

                    break;

                case 5:

                    System.out.println("Admin logged out.");

                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}
