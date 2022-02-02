package M04_JavaOOP.L03_Inheritance.Exercises.T05Restaurant.restaurant;

import java.math.BigDecimal;

public class MainDish extends Food {

    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}