package M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.components;

public class Motherboard extends BaseComponent {
    private final static double MULTIPLIER = 1.25;

    public Motherboard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, MULTIPLIER * overallPerformance, generation);
    }
}