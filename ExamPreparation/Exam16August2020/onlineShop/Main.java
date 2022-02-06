package M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop;

import M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.core.EngineImpl;
import M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}