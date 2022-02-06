package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T byNumber(int number);
}
