package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}
