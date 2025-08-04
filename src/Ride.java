import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private int minHeightCm;
    private Employee operator;

    // Queue to manage current waiting visitors
    private Queue<Visitor> visitorQueue;

    // List to maintain ride history
    private List<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "";
        this.minHeightCm = 0;
        this.operator = null;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Constructor with parameters
    public Ride(String rideName, int minHeightCm, Employee operator) {
        this.rideName = rideName;
        this.minHeightCm = minHeightCm;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public int getMinHeightCm() { return minHeightCm; }
    public void setMinHeightCm(int minHeightCm) { this.minHeightCm = minHeightCm; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    // Interface Methods

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.offer(visitor);
        System.out.println(visitor.getName() + " added to " + rideName + " queue.");
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = visitorQueue.poll();
        if (removed != null) {
            System.out.println(removed.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty. No visitor to remove.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Current Queue for " + rideName + ":");
        if (visitorQueue.isEmpty()) {
            System.out.println(" - Queue is empty");
        } else {
            for (Visitor v : visitorQueue) {
                System.out.println(" - " + v.getName());
            }
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + rideName + ":");
        if (rideHistory.isEmpty()) {
            System.out.println(" - No visitors have taken this ride yet.");
        } else {
            for (Visitor v : rideHistory) {
                System.out.println(" - " + v.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in queue to run the ride.");
            return;
        }

        Visitor rider = visitorQueue.poll();
        System.out.println("Running one cycle with: " + rider.getName());
        addVisitorToHistory(rider);
    }
}
