package M04_JavaOOP.L03_Inheritance.Exercises.T04NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {
    private final static double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePowers) {
        super(fuel, horsePowers);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
