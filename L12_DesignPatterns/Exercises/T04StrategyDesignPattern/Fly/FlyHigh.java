package M04_JavaOOP.L12_DesignPatterns.Exercises.T04StrategyDesignPattern.Fly;

public class FlyHigh implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("Fly high");
    }
}