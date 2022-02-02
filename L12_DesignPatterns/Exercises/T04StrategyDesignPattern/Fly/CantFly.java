package M04_JavaOOP.L12_DesignPatterns.Exercises.T04StrategyDesignPattern.Fly;

public class CantFly implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}