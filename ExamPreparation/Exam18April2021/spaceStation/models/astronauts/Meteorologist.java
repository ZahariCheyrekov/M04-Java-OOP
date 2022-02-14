package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private static final double OXYGEN = 90;

    public Meteorologist(String name) {
        super(name, OXYGEN);
    }
}