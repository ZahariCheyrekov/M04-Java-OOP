package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation;

import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.core.Controller;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.core.ControllerImpl;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.core.Engine;
import M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}