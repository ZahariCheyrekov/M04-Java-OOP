package catHouse.common;

public class DataValidator {

    public static void validateStringData(String stringToValidate, String exceptionMessage) {
        if (stringToValidate == null || stringToValidate.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void validateCatPrice(double price, String exceptionMessage) {
        if (price <= 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void checkHouseCapacity(int catsInTheHouse, int houseCapacity, String exceptionMessage) {
        if (houseCapacity <= catsInTheHouse) {
            throw new IllegalStateException(exceptionMessage);
        }
    }
}