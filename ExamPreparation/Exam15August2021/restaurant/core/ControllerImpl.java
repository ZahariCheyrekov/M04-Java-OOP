package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.core;

import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.core.interfaces.Controller;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.drinks.Fresh;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.drinks.Smoothie;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.healthyFoods.Salad;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.healthyFoods.VeganBiscuits;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.tables.InGarden;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.tables.Indoors;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.tables.interfaces.Table;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces.BeverageRepository;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces.HealthFoodRepository;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;

import static M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.common.ExceptionMessages.*;
import static M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    @Override
    public String reserve(int numberOfPeople) {
        Collection<Table> tables = this.tableRepository.getAllEntities();

        Table table = tables.stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        String message = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);

        if (table != null) {
            table.reserve(numberOfPeople);
            message = String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }

        return message;
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(food);

        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Beverages beverage = beveragesRepository.beverageByName(name, brand);

        if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);

        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }
}
