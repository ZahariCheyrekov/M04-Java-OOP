package M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.toys;

public class Mouse extends BaseToy {
    private static final int SOFTNESS = 5;
    private static final double PRICE = 15;

    public Mouse() {
        super(SOFTNESS, PRICE);
    }
}