package M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Layouts;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Enums.ReportLevel;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel, message);
    }
}