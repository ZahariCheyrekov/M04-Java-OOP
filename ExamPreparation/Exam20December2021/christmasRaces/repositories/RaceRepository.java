package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.repositories;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.entities.races.Race;
import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class RaceRepository implements Repository<Race> {
    private final Map<String, Race> races;

    public RaceRepository() {
        races = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return races.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(races.values());
    }

    @Override
    public void add(Race race) {
        races.put(race.getName(), race);
    }

    @Override
    public boolean remove(Race model) {
        if(null == races.remove(model.getName()))
            return false;
        return true;
    }
}
