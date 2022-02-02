package M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Factories;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Enums.ReportLevel;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Appenders.ConsoleAppender;
//import M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Appenders.FileAppender;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Appender;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Factory;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String input) {
        String[] tokens = input.split(" ");

        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = layoutFactory.produce(layoutType);
        Appender appender = null;
        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else if (appenderType.equals("FileAppender")) {
//            appender = new FileAppender(layout);
        }

        if (tokens.length >= 3) {
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }

        return appender;
    }
}