public class AssignmentTwo {

    public static void main(String[] args) {
        // Entry point for the Park Rides Visitor Management System
        System.out.println("Welcome to the Park Rides Visitor Management System!");
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
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
        // Future implementation for Part 4A
    }

    public void partFourB() {
        // Future implementation for Part 4B
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
