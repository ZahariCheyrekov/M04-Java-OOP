package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums;

import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums.BaseAquarium;

public class SaltwaterAquarium extends BaseAquarium {
    private final static int CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, CAPACITY);
    }
}