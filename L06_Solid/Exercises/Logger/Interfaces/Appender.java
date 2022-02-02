package M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Enums.ReportLevel;

public interface Appender {
    void append(String time, String message, ReportLevel reportLevel);
    void setReportLevel(ReportLevel reportLevel);
}