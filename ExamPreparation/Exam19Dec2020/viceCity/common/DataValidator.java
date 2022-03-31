package viceCity.common;

public class DataValidator {

    private static final int LOWEST_RANGE_POSSIBLE = 0;

    public static void validateString(String dataToValidate, String exceptionMessage) {
        if (dataToValidate == null || dataToValidate.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void validateInt(int dataToValidate, String exceptionMessage) {
        if (dataToValidate < LOWEST_RANGE_POSSIBLE) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}