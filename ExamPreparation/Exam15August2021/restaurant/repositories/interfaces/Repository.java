package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAllEntities();

    void add(T entity);

}
