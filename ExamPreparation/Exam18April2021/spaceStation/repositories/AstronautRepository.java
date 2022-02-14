package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.repositories;


import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override

    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.put(model.getName(), model);
    }

    @Override
    public boolean remove(Astronaut model) {
        Astronaut astronaut = this.astronauts.remove(model.getName());
        return astronaut != null;
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.get(name);
    }
}