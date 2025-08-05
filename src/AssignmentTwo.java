public class AssignmentTwo {

    public static void main(String[] args) {
        // Entry point for the Park Rides Visitor Management System
        System.out.println("Welcome to the Park Rides Visitor Management System!");
        AssignmentTwo a2= new AssignmentTwo();
        a2.partThree();
        a2.partFourA();
        a2.partFourB();
    }

    public void partThree() {
        System.out.println("\n=== Part 3: Queue Management Demo ===");

        // Create an Employee to operate the ride
        Employee operator = new Employee("Alex", 30, "Male", "EMP001", "Ride Operator");

        // Create a Ride and assign the employee
        Ride rollerCoaster = new Ride("Thunder Coaster", 120, operator);

        // Create Visitors
        Visitor v1 = new Visitor("John Doe", 25, "Male", "T001", false);
        Visitor v2 = new Visitor("Jane Smith", 22, "Female", "T002", true);
        Visitor v3 = new Visitor("Mike Lee", 30, "Male", "T003", false);
        Visitor v4 = new Visitor("Emily Clark", 18, "Female", "T004", false);
        Visitor v5 = new Visitor("Liam Brown", 27, "Male", "T005", true);

        // Add visitors to the queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Remove one visitor (front of queue)
        rollerCoaster.removeVisitorFromQueue();

        // Print current queue
        rollerCoaster.printQueue();
    }


    public void partFourA() {
        System.out.println("\n=== Part 4A: Ride History Demo ===");

        // Create an operator
        Employee operator = new Employee("Sarah", 28, "Female", "EMP102", "Supervisor");

        // Create a Ride
        Ride skyDrop = new Ride("Sky Drop", 130, operator);

        // Create Visitors
        Visitor v1 = new Visitor("Adam King", 20, "Male", "T101", false);
        Visitor v2 = new Visitor("Nina Rose", 23, "Female", "T102", true);
        Visitor v3 = new Visitor("Tom Harris", 26, "Male", "T103", false);
        Visitor v4 = new Visitor("Lily White", 21, "Female", "T104", false);
        Visitor v5 = new Visitor("Sam Green", 24, "Male", "T105", true);

        // Add to history
        skyDrop.addVisitorToHistory(v1);
        skyDrop.addVisitorToHistory(v2);
        skyDrop.addVisitorToHistory(v3);
        skyDrop.addVisitorToHistory(v4);
        skyDrop.addVisitorToHistory(v5);

        // Check if a visitor is in the history
        skyDrop.checkVisitorFromHistory(v3); // Should return true
        Visitor v6 = new Visitor("Unknown Visitor", 30, "Other", "T999", false);
        skyDrop.checkVisitorFromHistory(v6); // Should return false

        // Print number of visitors
        System.out.println("Total visitors who took the ride: " + skyDrop.numberOfVisitors());

        // Print all visitor history
        skyDrop.printRideHistory();
    }


    public void partFourB() {
        System.out.println("\n=== Part 4B: Sorting Ride History Demo ===");

        Employee operator = new Employee("Tom", 40, "Male", "EMP999", "Manager");
        Ride ferrisWheel = new Ride("Ferris Wheel", 100, operator);

        // Create Visitors
        Visitor v1 = new Visitor("Alice", 22, "Female", "T210", false);
        Visitor v2 = new Visitor("Bob", 28, "Male", "T211", false);
        Visitor v3 = new Visitor("Charlie", 25, "Male", "T212", true);
        Visitor v4 = new Visitor("Alice", 20, "Female", "T213", false); // Same name as v1, diff age
        Visitor v5 = new Visitor("Eve", 27, "Female", "T214", true);

        // Add to history
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // Print before sort
        System.out.println("\n--- Before Sorting ---");
        ferrisWheel.printRideHistory();

        // Sort using VisitorNameAgeComparator
        VisitorNameAgeComparator comparator = new VisitorNameAgeComparator();
        ferrisWheel.sortRideHistory(comparator);

        // Print after sort
        System.out.println("\n--- After Sorting by Name then Age ---");
        ferrisWheel.printRideHistory();
    }


    public void partFive() {
        // Future implementation for Part 5
    }

    public void partSix() {
        // Future implementation for Part 6
    }

    public void partSeven() {
        // Future implementation for Part 7
    }
}
