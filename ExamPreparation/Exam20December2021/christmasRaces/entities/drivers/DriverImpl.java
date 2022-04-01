package christmasRaces.entities.drivers;

import christmasRaces.common.DataValidator;
import christmasRaces.entities.cars.Car;

import static christmasRaces.common.ExceptionMessages.*;

public class DriverImpl implements Driver {

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        String exceptionMessage = String.format(INVALID_NAME, name, 5);
        DataValidator.validateString(name, exceptionMessage, 5);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        DataValidator.validateCar(car, CAR_INVALID);
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
