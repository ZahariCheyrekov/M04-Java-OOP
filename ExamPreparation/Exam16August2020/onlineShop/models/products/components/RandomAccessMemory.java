package M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.models.products.components;

public class RandomAccessMemory extends BaseComponent {
    private static final double MULTIPLIER = 1.20;

    public RandomAccessMemory(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, MULTIPLIER * overallPerformance, generation);
    }
}