package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.races;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Set<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        drivers = new HashSet<>();
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    private void setLaps(int laps) {
        if(laps < 1)
            throw new IllegalArgumentException("Laps cannot be less than 1.");
        this.laps = laps;
    }

    private void setName(String name) {
        if (name.trim().length() < 5)
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.", name));
        this.name = name;
    }

    public void addDriver(Driver driver) {
        if(driver == null)
            throw new IllegalArgumentException("Driver cannot be null.");
        if (!driver.getCanParticipate())
            throw new IllegalArgumentException(String.format(
                    "Driver %s could not participate in race.", driver.getName()));
        if(drivers.contains(driver))
            throw new IllegalArgumentException(String.format(
                    "Driver %s is already added in %s race.", driver.getName(), this.name));
        drivers.add(driver);
    }


}
