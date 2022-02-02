package M04_JavaOOP.L03_Inheritance.Exercises.T04NeedForSpeed;

public class Car extends Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePowers) {
        super(fuel, horsePowers);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
