package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getModels();

    void add(T model);

    boolean remove(T model);

    T find(String name);
}
