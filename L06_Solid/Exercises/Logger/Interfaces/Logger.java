package M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces;

public interface Logger {
    void logInfo(String time, String message);

    void logWarning(String time, String message);

    void logError(String time, String message);

    void logCritical(String time, String message);

    void logFatal(String time, String message);
}