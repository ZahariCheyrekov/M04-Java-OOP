package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T04BarracksWarsTheCommandsStrikeBack.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
