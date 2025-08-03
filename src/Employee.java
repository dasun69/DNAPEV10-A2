// Represents a theme park employee, inheriting from Person
public class Employee extends Person {
    private String employeeId;
    private String role;

    // Default constructor
    public Employee() {
        super();
        this.employeeId = "";
        this.role = "";
    }

    // Constructor with parameters
    public Employee(String name, int age, String gender, String employeeId, String role) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.role = role;
    }

    // Getters and setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
