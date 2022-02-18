package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.core;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.core.interfaces.Controller;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.cars.Car;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.cars.MuscleCar;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.cars.SportsCar;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.drivers.Driver;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.drivers.DriverImpl;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.races.Race;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.races.RaceImpl;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.common.ExceptionMessages.RACE_INVALID;
import static M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.common.ExceptionMessages.RACE_NOT_FOUND;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        if(driverRepository.getByName(driverName) != null)
            throw new IllegalArgumentException(String.format("Driver %s is already created.", driverName));

        driverRepository.add(new DriverImpl(driverName));
        return String.format("Driver %s is created.", driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null)
            throw new IllegalArgumentException(String.format("Car %s is already created.", model));
        switch (type) {
            case "Muscle":
                carRepository.add(new MuscleCar(model, horsePower));
                return String.format("MuscleCar %s is created.", model);
            case "Sports":
                carRepository.add(new SportsCar(model, horsePower));
                return String.format("SportsCar %s is created.", model);
        }
        return null;
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null)
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        Car car = carRepository.getByName(carModel);
        if(car == null)
            throw new IllegalArgumentException(String.format("Car %s could not be found.", carModel));
        driver.addCar(car);
        return String.format("Driver %s received car %s.", driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null)
            throw new IllegalArgumentException(String.format("Race %s could not be found.", raceName));
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null)
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        race.addDriver(driver);
        return String.format("Driver %s added in %s race.", driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Collection<Driver> participants = race.getDrivers();

        if (participants.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        int laps = race.getLaps();

        List<Driver> fastestThree = participants
                .stream()
                .sorted((p2, p1) -> Double.compare(p1.getCar().calculateRacePoints(laps),
                        p2.getCar().calculateRacePoints(laps)))
                .limit(3)
                .collect(Collectors.toList());

        this.raceRepository.remove(race);

        StringBuilder message = new StringBuilder();

        Driver first = fastestThree.get(0);
        Driver second = fastestThree.get(1);
        Driver third = fastestThree.get(2);

        message.append(String.format("Driver %s wins %s race.", first.getName(), raceName))
                .append(System.lineSeparator());
        message.append(String.format("Driver %s is second in %s race.", second.getName(), raceName))
                .append(System.lineSeparator());
        message.append(String.format("Driver %s is third in %s race.", third.getName(), raceName))
                .append(System.lineSeparator());

        return message.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        if(raceRepository.getByName(name) != null)
            throw new IllegalArgumentException(String.format("Race %s is already created.", name));
        raceRepository.add(new RaceImpl(name, laps));
        return String.format("Race %s is created.", name);
    }
}
