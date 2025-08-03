// Represents a theme park visitor, inheriting from Person
public class Visitor extends Person {
    private String ticketNumber;
    private boolean isVIP;

    // Default constructor
    public Visitor() {
        super();
        this.ticketNumber = "";
        this.isVIP = false;
    }

    // Constructor with parameters
    public Visitor(String name, int age, String gender, String ticketNumber, boolean isVIP) {
        super(name, age, gender);
        this.ticketNumber = ticketNumber;
        this.isVIP = isVIP;
    }

    // Getters and setters
    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }

    public boolean isVIP() { return isVIP; }
    public void setVIP(boolean isVIP) { this.isVIP = isVIP; }
}
