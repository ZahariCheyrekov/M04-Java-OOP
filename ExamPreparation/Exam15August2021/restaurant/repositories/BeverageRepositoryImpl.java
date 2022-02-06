package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories;

import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces.BeverageRepository;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private List<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return beverages.stream()
                .filter(b -> b.getName().equals(drinkName) && b.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return beverages;
    }

    @Override
    public void add(Beverages entity) {
        beverages.add(entity);
    }
}