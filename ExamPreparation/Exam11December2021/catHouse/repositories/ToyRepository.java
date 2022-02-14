package M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.repositories;

import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {
    private Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return this.toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        return this.toys
                .stream()
                .filter(toy -> toy.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}