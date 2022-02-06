package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity;

import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.core.ControllerImpl;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.core.EngineImpl;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.core.interfaces.Controller;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}