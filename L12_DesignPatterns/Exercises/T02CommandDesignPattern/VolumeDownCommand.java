package M04_JavaOOP.L12_DesignPatterns.Exercises.T02CommandDesignPattern;

public class VolumeDownCommand implements Command{
    Radio radio;

    public VolumeDownCommand(Radio radio) {
        this.radio = radio;
    }

    @Override
    public void execute() {
        radio.volumeDown();
    }
}