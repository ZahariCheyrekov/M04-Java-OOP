package aquarium.entities.aquariums;

import aquarium.common.DataValidator;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {

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

    private void setName(String name) {
        DataValidator.validateString(name, AQUARIUM_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        int decorationsComfortSum = this.decorations
                .stream()
                .mapToInt(Decoration::getComfort)
                .sum();

        return decorationsComfortSum;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity <= this.fish.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
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
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {

        String names = this.fish
                .isEmpty()
                ? EMPTY_AQUARIUM
                : this.fish
                .stream()
                .map(Fish::getName)
                .collect(Collectors.joining(FISH_NAMES_DELIMITER));

        StringBuilder info = new StringBuilder();

        info.append(String.format(AQUARIUM_NAME_TYPE_INFO, this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        info.append(String.format(AQUARIUM_FISH_NAMES, names)).append(System.lineSeparator());
        info.append(String.format(AQUARIUM_DECORATIONS, this.decorations.size())).append(System.lineSeparator());
        info.append(String.format(AQUARIUM_COMFORT, this.calculateComfort())).append(System.lineSeparator());

        return info.toString().trim();
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
