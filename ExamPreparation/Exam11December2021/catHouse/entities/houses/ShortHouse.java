package M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.houses;

public class ShortHouse extends BaseHouse {
    private static final int CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, CAPACITY);
    }
}