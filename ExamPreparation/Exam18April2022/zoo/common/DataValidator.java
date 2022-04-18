package zoo.common;

public class DataValidator {

    private static final double INVALID_PRICE = 0;

    public static void validateString(String dataToValidate, String exceptionMessage) {
        if (dataToValidate == null || dataToValidate.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void validateAnimalPrice(double price, String exceptionMessage) {
        if (price <= INVALID_PRICE) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}