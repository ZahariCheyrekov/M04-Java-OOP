package M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.computers;

import M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.peripherals.Peripheral;
import M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.Product;
import M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.components.Component;

import java.util.List;

public interface Computer extends Product {
    List<Component> getComponents();

    List<Peripheral> getPeripherals();

    void addComponent(Component component);

    Component removeComponent(String componentType);

    void addPeripheral(Peripheral peripheral);

    Peripheral removePeripheral(String peripheralType);
}