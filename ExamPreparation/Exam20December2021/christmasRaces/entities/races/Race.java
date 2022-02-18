package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.races;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
