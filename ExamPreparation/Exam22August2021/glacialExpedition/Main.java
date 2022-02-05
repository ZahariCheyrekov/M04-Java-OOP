package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition;

import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.core.Controller;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.core.ControllerImpl;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.core.Engine;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
