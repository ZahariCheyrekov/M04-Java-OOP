package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private static final double OXYGEN = 50;

    public Geodesist(String name) {
        super(name, OXYGEN);
    }
}