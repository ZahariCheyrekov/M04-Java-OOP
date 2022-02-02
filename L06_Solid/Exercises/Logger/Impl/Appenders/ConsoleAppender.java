package M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Appenders;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Enums.ReportLevel;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (this.canAppend(reportLevel)) {
            String formattedMessage = this.layout.format(time, message, reportLevel);
            increaseMessageCount();
            System.out.println(formattedMessage);
        }
    }
}