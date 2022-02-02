package M04_JavaOOP.L05_Polymorphism.Exercises.T04Word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new CommandInit(text);
        commandInterface.init();
        return commandInterface;
    }
}