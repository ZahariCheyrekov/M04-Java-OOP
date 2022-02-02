package M04_JavaOOP.L12_DesignPatterns.Exercises.T03BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza().withWeight(200).withName("Margaritta").withTopping("A");
        Pizza pizza2 = new Pizza().withWeight(200).withName("Margaritta").withTopping("A");
    }
}