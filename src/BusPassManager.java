import java.util.ArrayList;
import java.util.Scanner;

public class BusPassManager {

    private ArrayList<BusPass> passes = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private int nextPassId = 1001;

    // Apply for bus pass

    public void applyPass(User user) {

        System.out.println("\n===== APPLY FOR BUS PASS =====");

        System.out.print("Enter Source: ");
        String source = scanner.nextLine();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter Pass Type (Monthly/Quarterly): ");
        String passType = scanner.nextLine();

        double amount;

        if (passType.equalsIgnoreCase("Monthly")) {

            amount = 500;

        } else if (passType.equalsIgnoreCase("Quarterly")) {

            amount = 1200;

        } else {

            System.out.println("Invalid pass type.");
            return;
        }

        BusPass pass = new BusPass(
                nextPassId,
                user.getUserId(),
                source,
                destination,
                passType,
                amount
        );

        passes.add(pass);

        System.out.println("\nBus Pass Application Submitted!");
        System.out.println("Pass ID: " + nextPassId);
        System.out.println("Status: Pending");

        nextPassId++;
    }

    // View user's passes

    public void viewMyPasses(User user) {

        System.out.println("\n===== MY BUS PASSES =====");

        boolean found = false;

        for (BusPass pass : passes) {

            if (pass.getUserId() == user.getUserId()) {

                pass.displayPass();

                found = true;
            }
        }

        if (!found) {

            System.out.println("No bus pass found.");
        }
    }

    // Admin view all passes

    public void viewAllPasses() {

        System.out.println("\n===== ALL BUS PASS APPLICATIONS =====");

        if (passes.isEmpty()) {

            System.out.println("No applications found.");

            return;
        }

        for (BusPass pass : passes) {

            pass.displayPass();
        }
    }

    // Approve pass

    public void approvePass() {

        System.out.print("\nEnter Pass ID to approve: ");

        int id = scanner.nextInt();

        scanner.nextLine();

        for (BusPass pass : passes) {

            if (pass.getPassId() == id) {

                pass.setStatus("Approved");

                System.out.println("Pass approved successfully.");

                return;
            }
        }

        System.out.println("Pass not found.");
    }

    // Reject pass

    public void rejectPass() {

        System.out.print("\nEnter Pass ID to reject: ");

        int id = scanner.nextInt();

        scanner.nextLine();

        for (BusPass pass : passes) {

            if (pass.getPassId() == id) {

                pass.setStatus("Rejected");

                System.out.println("Pass rejected.");

                return;
            }
        }

        System.out.println("Pass not found.");
    }
}