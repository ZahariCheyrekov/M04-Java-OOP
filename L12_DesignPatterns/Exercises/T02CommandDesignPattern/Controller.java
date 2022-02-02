package M04_JavaOOP.L12_DesignPatterns.Exercises.T02CommandDesignPattern;

public class Controller {
    Command command;

    public void executeCommand(Command command) {
        this.command = command;
        command.execute();
    }
}