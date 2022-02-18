package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.repositories;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.drivers.Driver;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class DriverRepository implements Repository<Driver> {
    private final Map<String, Driver> drivers;

    public DriverRepository() {
        drivers = new LinkedHashMap<>();
    }


    @Override
    public Driver getByName(String name) {
        return drivers.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers.values());
    }

    @Override
    public void add(Driver model) {
        drivers.put(model.getName(), model);
    }

    @Override
    public boolean remove(Driver model) {
        if(drivers.remove(model.getName()) == null)
            return false;

        return true;
    }
}
