package M04_JavaOOP.L02_Encapsulation.Lab.T01SortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return String.format("%s %s is %d years old.",
                this.getFirstName(),
                this.getLastName(),
                this.getAge());
    }
}