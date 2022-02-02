package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T04ValidPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public void setFirstName(String firstName) {
        if (validName(firstName, "first")) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (validName(lastName, "last")) {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in the range [0...120]");
        }
        this.age = age;
    }

    public boolean validName(String name, String partOfName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The " + partOfName + " name cannot be null or empty");
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Hello! I am %s %s and I am %d years old.",
                this.firstName, this.lastName, this.age);
    }
}