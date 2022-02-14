package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.repositories;


import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.planets.Planet;

import java.util.*;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    @Override
    public void add(Planet model) {
        this.planets.put(model.getName(), model);
    }

    @Override
    public boolean remove(Planet model) {
        Planet planet = this.planets.remove(model.getName());
        return planet != null;
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.get(name);
    }
}