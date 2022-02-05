package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.states;

import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class StateImpl implements State {
    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setExhibits(Collection<String> exhibits) {
        this.exhibits = exhibits;
    }
}
