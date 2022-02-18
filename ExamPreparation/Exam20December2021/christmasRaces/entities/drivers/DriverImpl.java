package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.drivers;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.cars.Car;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        car = null;
        numberOfWins = 0;
        canParticipate = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    public boolean getCanParticipate() {
        return canParticipate;
    }

    private void setName(String name) {
        if (name.trim().length() < 5)
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.", name));
        this.name = name;
    }

    public void addCar(Car car) {
        if(car == null)
            throw new IllegalArgumentException("Car cannot be null.");
        this.car = car;
        this.canParticipate = true;
    }

    public void winRace() {
        this.numberOfWins++;
    }
}
