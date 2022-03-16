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

  

        if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);

        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }
}
