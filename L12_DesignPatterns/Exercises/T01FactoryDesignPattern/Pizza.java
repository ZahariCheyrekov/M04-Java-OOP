package M04_JavaOOP.L12_DesignPatterns.Exercises.T01FactoryDesignPattern;

public abstract class Pizza {
    public double diameter;

    public Pizza(double diameter) {
        this.diameter = diameter;
    }

    abstract public void prepare();
    abstract public void bake();
    abstract public void box();
}