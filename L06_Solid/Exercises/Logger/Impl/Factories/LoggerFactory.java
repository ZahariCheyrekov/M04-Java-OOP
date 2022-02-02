package M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Factories;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.MessageLogger;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Appender;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Factory;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Logger;


public class LoggerFactory implements Factory<Logger> {
    AppenderFactory appenderFactory;

    public LoggerFactory() {
        this.appenderFactory = new AppenderFactory();
    }

    @Override
    public Logger produce(String input) {
        String[] tokens = input.split(System.lineSeparator());
        Appender[] appenders = new Appender[tokens.length];

        for (int i = 0; i < appenders.length; i++) {
            appenders[i] = this.appenderFactory.produce(tokens[i]);
        }

        return new MessageLogger(appenders);
    }
}