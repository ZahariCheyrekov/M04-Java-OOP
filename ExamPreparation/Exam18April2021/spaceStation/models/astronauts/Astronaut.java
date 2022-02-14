package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts;

import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
