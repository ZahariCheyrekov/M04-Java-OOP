package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.repositories;

import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
