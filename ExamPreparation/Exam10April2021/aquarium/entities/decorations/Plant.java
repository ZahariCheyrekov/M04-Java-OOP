package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations;

public class Plant extends BaseDecoration {
    private final static int COMFORT = 5;
    private final static double DECORATION = 10;

    public Plant() {
        super(COMFORT, DECORATION);
    }
}