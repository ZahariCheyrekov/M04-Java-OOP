package restaurant.common;

public class DataValidator {

    private static final int MINIMUM_NUMBER = 0;

    public static void validateString(String dataToValidate, String exceptionMessage) {
        if (dataToValidate == null || dataToValidate.trim().isEmpty()) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateDouble(double dataToValidate, String exceptionMessage) {
        if (dataToValidate <= MINIMUM_NUMBER) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateInt(int dataToValidate, String exceptionMessage) {
        if (dataToValidate <= MINIMUM_NUMBER) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
