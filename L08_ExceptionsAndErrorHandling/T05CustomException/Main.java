package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T05CustomException;

public class Main {
    public static void main(String[] args) {
        try {
            // Invalid name for Student class
            Student invalid = new Student("4mark", "mark@gmail.com");

            // Valid Student data
            Student valid = new Student("Gorilla", "gorilla.gang@gmail.com");
            System.out.println(valid);

        } catch (InvalidPersonNameException exception) {
            System.out.println(exception.getMessage());
        }
    }
}