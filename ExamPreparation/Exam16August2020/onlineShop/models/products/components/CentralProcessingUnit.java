package M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.components;

public class CentralProcessingUnit extends BaseComponent {
    private final static double MULTIPLIER = 1.25;

    public CentralProcessingUnit(int id, String manufacturer, String model,
                                 double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, MULTIPLIER * overallPerformance, generation);
    }
}