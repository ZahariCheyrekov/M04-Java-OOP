package M04_JavaOOP.L02_Encapsulation.Exercises.T03ShoppigSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {

            String message = String.format("%s can't afford %s", this.getName(), product.getName());
            throw new IllegalArgumentException(message);
        }

        this.products.add(product);
        this.money -= product.getCost();

        System.out.printf("%s bought %s%n", this.getName(), product.getName());
    }
}