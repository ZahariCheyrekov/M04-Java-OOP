package M04_JavaOOP.L03_Inheritance.Exercises.T04NeedForSpeed;

public class SportCar extends Car {
    private static final double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePowers) {
        super(fuel, horsePowers);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
