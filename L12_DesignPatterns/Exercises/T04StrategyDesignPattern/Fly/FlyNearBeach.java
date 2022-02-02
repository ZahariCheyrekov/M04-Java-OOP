package M04_JavaOOP.L12_DesignPatterns.Exercises.T04StrategyDesignPattern.Fly;

public class FlyNearBeach implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("Fly by the beach");
    }
}