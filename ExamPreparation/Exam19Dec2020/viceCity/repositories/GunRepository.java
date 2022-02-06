package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.repositories;

import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.repositories.interfaces.Repository;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Gun model) {
        this.models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        Gun removed = this.models.remove(model.getName());
        return removed != null;
    }

    @Override
    public Gun find(String name) {
        return this.models.get(name);
    }
}