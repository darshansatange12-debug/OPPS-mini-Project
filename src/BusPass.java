public class BusPass {

    private int passId;
    private int userId;
    private String source;
    private String destination;
    private String passType;
    private double amount;
    private String status;

    public BusPass(int passId, int userId, String source,
                   String destination, String passType,
                   double amount) {

        this.passId = passId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.passType = passType;
        this.amount = amount;
        this.status = "Pending";
    }

    public int getPassId() {
        return passId;
    }

    public int getUserId() {
        return userId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getPassType() {
        return passType;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayPass() {

        System.out.println("\n===== BUS PASS DETAILS =====");

        System.out.println("Pass ID      : " + passId);
        System.out.println("User ID      : " + userId);
        System.out.println("Source       : " + source);
        System.out.println("Destination  : " + destination);
        System.out.println("Pass Type    : " + passType);
        System.out.println("Amount       : ₹" + amount);
        System.out.println("Status       : " + status);
    }
}
