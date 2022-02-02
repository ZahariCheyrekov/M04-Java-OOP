package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T05CustomException;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}