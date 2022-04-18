package zoo.entities.animals;

import zoo.common.DataValidator;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseAnimal implements Animal {

    private String name;
    private String kind;
    private double kg;
    private double price;

    private static final double INCREASE_IN_KILOGRAMS_PER_MEAL = 5;

    protected BaseAnimal(String name, String kind, double price) {
        this.setName(name);
        this.setKind(kind);
        this.setPrice(price);
    }

    private void setName(String name) {
        DataValidator.validateString(name, ANIMAL_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    private void setKind(String kind) {
        DataValidator.validateString(kind, ANIMAL_KIND_NULL_OR_EMPTY);
        this.kind = kind;
    }

    private void setPrice(double price) {
        DataValidator.validateAnimalPrice(price, ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        this.price = price;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public void eat() {
        this.kg += INCREASE_IN_KILOGRAMS_PER_MEAL;
    }

    @Override
    public double getKg() {
        return this.kg;
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