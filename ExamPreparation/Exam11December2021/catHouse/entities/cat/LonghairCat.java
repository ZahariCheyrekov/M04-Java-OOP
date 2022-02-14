package M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static final int KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        this.setKilograms(KILOGRAMS + 3);
    }
}