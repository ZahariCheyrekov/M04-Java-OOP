package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums;

import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations.Decoration;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.fish.Fish;

import java.util.Collection;

public interface Aquarium {
    int calculateComfort();

    String getName();

    void addFish(Fish fish);

    void removeFish(Fish fish);

    void addDecoration(Decoration decoration);

    void feed();

    String getInfo();

    Collection<Fish> getFish();

    Collection<Decoration> getDecorations();
}
