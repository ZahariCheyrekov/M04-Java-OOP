package M04_JavaOOP.L12_DesignPatterns.Exercises.T04StrategyDesignPattern;

import M04_JavaOOP.L12_DesignPatterns.Exercises.T04StrategyDesignPattern.Fly.CantFly;

public class Main {
    public static void main(String[] args) {
        Bird eagle = new Bird(new CantFly());
        eagle.fly();
        eagle.fly();
        eagle.fly();
    }
}