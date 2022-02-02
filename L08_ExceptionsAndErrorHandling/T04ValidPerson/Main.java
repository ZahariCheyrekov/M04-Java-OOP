package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T04ValidPerson;

public class Main {
    public static void main(String[] args) {
        try {
            // Valid data for Person class
            Person noName = new Person("  ", "Anibal", 19);
            Person noLastName = new Person("Bob", "  ", 20);
            Person negativeAge = new Person("Fred", "Peterson", -1);
            Person tooOld = new Person("Jack", "Waller", 999);

            //Valid data for Person class
            Person valid = new Person("Gorilla", "Gang", 99);
            System.out.println(valid);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}