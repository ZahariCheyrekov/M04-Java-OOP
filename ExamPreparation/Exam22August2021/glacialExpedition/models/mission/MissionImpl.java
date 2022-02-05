package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.mission;

import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers.Explorer;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        //Итерираме изследователите
        //итерираме експонатите на конкретната локация
        Collection<String> stateExhibits = state.getExhibits();
        for (Explorer explorer : explorers) {
            //1 изследовател
            while(explorer.canSearch() && stateExhibits.iterator().hasNext()){
                //Изследователя има енергия
                //Има експонати за изследване
                explorer.search();
                String currentExhibit = stateExhibits.iterator().next();
                explorer.getSuitcase().getExhibits().add(currentExhibit);
                stateExhibits.remove(currentExhibit);
            }
        }
    }
}
