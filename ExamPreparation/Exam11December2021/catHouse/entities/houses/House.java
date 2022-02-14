package M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.houses;

import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.cat.Cat;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.toys.Toy;

import java.util.Collection;

public interface House {
    int sumSoftness();

    void addCat(Cat cat);

    void removeCat(Cat cat);

    void buyToy(Toy toy);

    void feeding();

    String getStatistics();

    String getName();

    void setName(String name);

    Collection<Cat> getCats();

    Collection<Toy> getToys();
}
