package catHouse.entities.cat;

import catHouse.common.DataValidator;

import static catHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat {

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    protected BaseCat(String name, String breed, double price) {
        this.setName(name);
        this.setBreed(breed);
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        DataValidator.validateStringData(name, CAT_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    private void setBreed(String breed) {
        DataValidator.validateStringData(breed, CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        this.breed = breed;
    }

    private void setPrice(double price) {
        DataValidator.validateCatPrice(price, CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        this.price = price;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }
}
