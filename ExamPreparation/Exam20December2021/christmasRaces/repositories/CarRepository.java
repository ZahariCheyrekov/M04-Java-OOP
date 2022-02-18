package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.repositories;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.cars.Car;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class CarRepository implements Repository<Car> {
    private final Map<String,Car> models;

    public CarRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Car model) {
        models.put(model.getModel(), model);

    }

    @Override
    public boolean remove(Car model) {
        if (models.remove(model.getModel()) == null)
            return false;
        return true;
    }
}
