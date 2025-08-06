import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    private String rideName;
    private int minHeightCm;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;


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

    public Ride(String rideName, int minHeightCm, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.minHeightCm = minHeightCm;
        this.operator = operator;
        this.maxRider = Math.max(maxRider, 1); // Ensure at least 1 rider
        this.numOfCycles = 0;
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
        System.out.println("\n--- Running one ride cycle for: " + rideName + " ---");

        if (operator == null) {
            System.out.println("Cannot run ride. No operator assigned.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("Cannot run ride. Queue is empty.");
            return;
        }

        int ridersThisCycle = Math.min(maxRider, visitorQueue.size());

        System.out.println("Running cycle with " + ridersThisCycle + " visitor(s).");

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor v = visitorQueue.poll();
            addVisitorToHistory(v); 
        }

        numOfCycles++;
        System.out.println("Cycle complete. Total cycles run: " + numOfCycles);
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

    public void exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor v : rideHistory) {
                String line = v.getName() + "," + v.getAge() + "," + v.getGender() + ","
                            + v.getTicketNumber() + "," + v.isVIP();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Ride history exported successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 5) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String gender = parts[2];
                String ticketNumber = parts[3];
                boolean isVIP = Boolean.parseBoolean(parts[4]);

                Visitor visitor = new Visitor(name, age, gender, ticketNumber, isVIP);
                rideHistory.add(visitor);
                count++;
            }

            System.out.println("Successfully imported " + count + " visitor(s) from file: " + filename);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
        }
    }

}
