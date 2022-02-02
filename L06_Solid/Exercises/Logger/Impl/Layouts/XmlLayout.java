package M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Layouts;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Enums.ReportLevel;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Layout;


public class XmlLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format(
                "<log>%n   <date>%s</date>%n   <level>%s</level>%n   <message>%s</message>%n </log>%n",
                time, reportLevel, message);
    }
}