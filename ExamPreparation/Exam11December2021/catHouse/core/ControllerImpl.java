package M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.core;

import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.cat.Cat;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.cat.LonghairCat;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.cat.ShorthairCat;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.houses.House;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.houses.LongHouse;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.houses.ShortHouse;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.toys.Ball;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.toys.Mouse;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.entities.toys.Toy;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.repositories.Repository;
import M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.common.ConstantMessages.*;
import static M04_JavaOOP.ExamPreparation.Exam11December2021.catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
          
            case "LongHouse":
                house = new LongHouse(name);
                break;
           
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        this.houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        switch (type) {
            case "Ball":
                toy = new Ball();
           
                break;
            case "Mouse":
                toy = new Mouse();
          
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        this.toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House house = this.houses
                .stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        house.buyToy(toy);
        this.toys.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;

        switch (catType) {
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
         
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = this.houses
                .stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        String houseType = house.getClass().getSimpleName();

        boolean isValid = ((houseType.equals("LongHouse")) && (catType.equals("LonghairCat")) ||
                (houseType.equals("ShortHouse")) && (catType.equals("ShorthairCat")));

        if (isValid) {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            return UNSUITABLE_HOUSE;
        }
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses
                .stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        Collection<Cat> cats = house.getCats();

        for (Cat cat : cats) {
            cat.eating();
        }

        return String.format(FEEDING_CAT, cats.size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses
                .stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        Collection<Cat> cats = house.getCats();
        Collection<Toy> toys = house.getToys();

        double totalPrice = 0;

        double catsPrice = cats.stream().mapToDouble(Cat::getPrice).sum();
        double toysPrice = toys.stream().mapToDouble(Toy::getPrice).sum();

        totalPrice += (catsPrice + toysPrice);

        return String.format(VALUE_HOUSE, houseName, totalPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder stats = new StringBuilder();

        this.houses
                .forEach(house -> {
                    stats.append(String.format("%s %s:", house.getName(),
                                    house.getClass().getSimpleName()))
                            .append(System.lineSeparator());

                    List<Cat> cats = new ArrayList<>(house.getCats());

                    if (cats.size() == 0) {
                        stats.append("Cats: none").append(System.lineSeparator());
                    } else {
                        stats.append("Cats:");

                        for (Cat cat : cats) {
                            stats.append(" ").append(cat.getName());
                        }
                     
                        stats.append(System.lineSeparator());
                    }

                    List<Toy> toys = new ArrayList<>(house.getToys());

                    int toysCount = toys.size();
                    int sumOfSoftness = toys.stream().mapToInt(Toy::getSoftness).sum();

                    stats.append(String.format("Toys: %d Softness: %d", toysCount, sumOfSoftness))
                            .append(System.lineSeparator());
                });

        return stats.toString().trim();
    }
}
