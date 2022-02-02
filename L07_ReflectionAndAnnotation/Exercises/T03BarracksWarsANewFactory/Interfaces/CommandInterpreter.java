package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T03BarracksWarsANewFactory.Interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
