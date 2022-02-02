package M04_JavaOOP.L12_DesignPatterns.Exercises.T04StrategyDesignPattern;

import M04_JavaOOP.L12_DesignPatterns.Exercises.T04StrategyDesignPattern.Fly.FlyStrategy;

public class Bird {
    FlyStrategy strategy;

    public void fly() {
        this.strategy.fly();
    }

    public Bird(FlyStrategy strategy) {
        this.strategy = strategy;
    }

    public FlyStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FlyStrategy strategy) {
        this.strategy = strategy;
    }
}