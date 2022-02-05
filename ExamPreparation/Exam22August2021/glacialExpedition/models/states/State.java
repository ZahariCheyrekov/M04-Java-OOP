package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.states;

import java.util.Collection;

public interface State {
    Collection<String> getExhibits();

    String getName();
}
