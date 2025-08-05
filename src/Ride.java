import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private int minHeightCm;
    private Employee operator;

    // Queue for current ride queue (FIFO)
    private Queue<Visitor> visitorQueue;

    // LinkedList for ride history
    private LinkedList<Visitor> rideHistory;

    public Ride() {
        this.rideName = "";
        this.minHeightCm = 0;
        this.operator = null;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Constructor with parameters
    public Ride(String rideName, int minHeightCm, Employee operator) {
        this.rideName = rideName;
        this.minHeightCm = minHeightCm;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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
        System.out.println("Visitor " + visitor.getName() + " (Ticket: " + visitor.getTicketNumber() + ") added to " + rideName + " queue.");
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = visitorQueue.poll();
        if (removed != null) {
            System.out.println("Visitor " + removed.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty. No visitor to remove.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("\n--- Current Queue for " + rideName + " ---");
        if (visitorQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (Visitor v : visitorQueue) {
                System.out.println("Name: " + v.getName() + ", Age: " + v.getAge() +
                                ", Gender: " + v.getGender() +
                                ", Ticket#: " + v.getTicketNumber() +
                                ", VIP: " + (v.isVIP() ? "Yes" : "No"));
            }
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = rideHistory.contains(visitor);
        if (exists) {
            System.out.println(visitor.getName() + " has taken the ride before.");
        } else {
            System.out.println(visitor.getName() + " has NOT taken the ride yet.");
        }
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

     @Override
    public void printRideHistory() {
        System.out.println("\n--- Ride History for " + rideName + " ---");

        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken this ride yet.");
            return;
        }

        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println("Name: " + v.getName() + ", Age: " + v.getAge() +
                               ", Gender: " + v.getGender() +
                               ", Ticket#: " + v.getTicketNumber() +
                               ", VIP: " + (v.isVIP() ? "Yes" : "No"));
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

    @Override
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors to sort in ride history.");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted using provided comparator.");
    }



}
