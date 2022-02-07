package M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.peripherals;

import M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {
    private String connectionType;

    protected BasePeripheral(int id, String manufacturer, String model, double price,
                             double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return this.connectionType;
    }

    @Override
    public String toString() {
        return "Overall Performance: {overall performance}. Price: {price} - {product type}: " +
                "{manufacturer} {model} (Id: {id}) Connection Type: {connection type}";
    }
}
