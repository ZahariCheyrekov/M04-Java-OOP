package M04_JavaOOP.L12_DesignPatterns.Exercises.T02CommandDesignPattern;

public class Main {
    public static void main(String[] args) {
        Radio radio = new Radio();
        Controller controller = new Controller();

        controller.executeCommand(new VolumeUpCommand(radio));
        controller.executeCommand(new VolumeUpCommand(radio));
        controller.executeCommand(new VolumeDownCommand(radio));
        radio.volumeDown();

    }
}