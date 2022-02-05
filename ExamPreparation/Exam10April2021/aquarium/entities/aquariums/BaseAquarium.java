package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.aquariums;

import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.decorations.Decoration;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.common.ConstantMessages.WATER_NOT_SUITABLE;
import static M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        String fishWaterType = fish.getClass().getSimpleName().replaceAll("Fish", "");

        if (!this.getClass().getSimpleName().contains(fishWaterType)) {
            throw new IllegalStateException(WATER_NOT_SUITABLE);
        }

        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish currentFish : fish) {
            currentFish.eat();
        }
    }

    @Override
    public String getInfo() {

        String fishOutput = this.fish
                .isEmpty() ? "none" :
                this.fish
                        .stream()
                        .map(Fish::getName)
                        .collect(Collectors.joining(" "));

        return String.format("%s (%s):%n" +
                        "Fish: %s%n"
                        + "Decorations: %d%n"
                        + "Comfort: %d",
                this.name,
                this.getClass().getSimpleName(),
                fishOutput, this.decorations.size(),
                calculateComfort());
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}