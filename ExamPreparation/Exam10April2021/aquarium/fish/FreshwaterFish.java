package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.fish;

public class FreshwaterFish extends BaseFish {
    private int size = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        this.size += 3;
    }
}