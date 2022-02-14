package M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.houses;

import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.common.ConstantMessages;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.common.ExceptionMessages;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.cat.Cat;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.name = name;
        this.setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumSoftness() {
        return this.toys
                .stream()
                .mapToInt(Toy::getSoftness)
                .sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity <= this.cats.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : this.cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder stats = new StringBuilder();

        stats.append(String.format("%s %s:", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());

        List<Cat> catsList = null;

        if (this.cats.size() == 0) {
            stats.append("Cats: none").append(System.lineSeparator());
        } else {
            stats.append("Cats: ");

            catsList = new ArrayList<>(this.cats);

            for (int cat = 0; cat < catsList.size(); cat++) {
                String currentCatName = catsList.get(cat).getName();

                if (cat < catsList.size()) {
                    stats.append(currentCatName).append(", ");
                } else {
                    stats.append(currentCatName);
                }
            }

            stats.append(System.lineSeparator());
        }

        this.cats = catsList;
        return stats.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}