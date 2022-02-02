package M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Enums.ReportLevel;

public interface Layout {
    String format(String time, String message, ReportLevel reportLevel);
}