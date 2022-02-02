package M04_JavaOOP.L12_DesignPatterns.Exercises.T01FactoryDesignPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pizzaType = scanner.nextLine();
        PizzaFactory pizzaFactory = new PizzaFactory();
        Pizzeria pizzeria = new Pizzeria(pizzaFactory);
        pizzeria.orderPizza(pizzaType, 22);
    }
}