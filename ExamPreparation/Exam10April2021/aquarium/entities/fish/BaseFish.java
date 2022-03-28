package aquarium.entities.fish;

import aquarium.common.DataValidator;

import static aquarium.common.ExceptionMessages.*;

public abstract class BaseFish implements Fish {

    private String name;
    private String species;
    private int size;
    private double price;

    private static final int INCREASED_SIZE_PER_MEAL = 5;

    protected BaseFish(String name, String species, double price) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
    }

    @Override
    public void setName(String name) {
        DataValidator.validateString(name, FISH_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    private void setSpecies(String species) {
        DataValidator.validateString(species, SPECIES_NAME_NULL_OR_EMPTY);
        this.species = species;
    }

    private void setPrice(double price) {
        DataValidator.validateDouble(price, FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        this.price = price;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    public void eat() {
        this.size += INCREASED_SIZE_PER_MEAL;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
