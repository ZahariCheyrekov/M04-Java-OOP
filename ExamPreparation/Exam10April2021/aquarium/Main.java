package M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium;

import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.core.Engine;
import M04_JavaOOP.ExamPreparation.Exam10April2021.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
