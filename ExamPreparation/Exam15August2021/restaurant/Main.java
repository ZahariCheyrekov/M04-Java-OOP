package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant;

import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.core.ControllerImpl;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.core.EngineImpl;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.io.ConsoleReader;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.io.ConsoleWriter;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.core.interfaces.Controller;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.entities.tables.interfaces.Table;

import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.BeverageRepositoryImpl;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.HealthFoodRepositoryImpl;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.TableRepositoryImpl;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces.BeverageRepository;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces.HealthFoodRepository;
import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}