package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.drivers;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
