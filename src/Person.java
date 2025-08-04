// Abstract base class representing a person
public abstract class Person {
    private String name;
    private int age;
    private String gender;

    // Default constructor
    public Person() {
        this.name = "";
        this.age = 0;
        this.gender = "";
    }

    // Constructor with parameters
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
