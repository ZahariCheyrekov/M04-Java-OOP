package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces;

public interface BeverageRepository<T> extends Repository<T> {
    T beverageByName(String drinkName,String drinkBrand);
}
