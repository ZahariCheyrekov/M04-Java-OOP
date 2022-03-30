package CounterStriker.common;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

public class DataValidator {

    private static final int INVALID_NUMBER = 0;

    public static void validateString(String dataToValidate, String exceptionMessage) {
        if (dataToValidate == null || dataToValidate.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void validateInt(int dataToValidate, String exceptionMessage) {
        if (dataToValidate < INVALID_NUMBER) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void validateGun(Gun gun, String exceptionMessage) {
        if (gun == null) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void validatePlayer(Player player, String exceptionMessage) {
        if (player == null) {
            throw new NullPointerException(exceptionMessage);
        }
    }
}