// Represents a ride at the theme park
public class Ride {
    private String rideName;
    private int minHeightCm;
    private Employee operator;

    // Default constructor
    public Ride() {
        this.rideName = "";
        this.minHeightCm = 0;
        this.operator = null;
    }

    // Constructor with parameters
    public Ride(String rideName, int minHeightCm, Employee operator) {
        this.rideName = rideName;
        this.minHeightCm = minHeightCm;
        this.operator = operator;
    }

    // Getters and setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public int getMinHeightCm() { return minHeightCm; }
    public void setMinHeightCm(int minHeightCm) { this.minHeightCm = minHeightCm; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
}
