package M04_JavaOOP.L12_DesignPatterns.Exercises.T02CommandDesignPattern;

public class VolumeUpCommand implements Command {
    Radio radio;

    public VolumeUpCommand(Radio radio) {
        this.radio = radio;
    }

    @Override
    public void execute() {
        radio.volumeUp();
    }
}