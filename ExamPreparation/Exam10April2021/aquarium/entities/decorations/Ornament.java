package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations;

public class Ornament extends BaseDecoration {
    private final static int COMFORT = 1;
    private final static double DECORATION = 5;

    public Ornament() {
        super(COMFORT, DECORATION);
    }
}