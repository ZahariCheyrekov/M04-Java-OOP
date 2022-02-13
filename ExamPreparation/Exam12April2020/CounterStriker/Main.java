package M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker;

import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.core.EngineImpl;
import M04_JavaOOP.ExamPreparation.Exam12April2020.CounterStriker.core.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}