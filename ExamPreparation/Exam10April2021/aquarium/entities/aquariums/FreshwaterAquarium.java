package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium {
    private final static int CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY);
    }
}