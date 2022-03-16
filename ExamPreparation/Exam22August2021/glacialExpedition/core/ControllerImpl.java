package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.core;

import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.common.ConstantMessages;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.common.ExceptionMessages;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers.AnimalExplorer;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers.Explorer;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers.GlacierExplorer;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers.NaturalExplorer;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.mission.Mission;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.mission.MissionImpl;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.states.State;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.states.StateImpl;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.repositories.ExplorerRepository;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.repositories.Repository;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int exploredStates;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        this.stateRepository.add(state);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        this.explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        List<Explorer> explorers = this.explorerRepository.getCollection().stream()
                .filter(explorer -> explorer.getEnergy() > 50)
                .collect(Collectors.toList());

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State stateToExplore = this.stateRepository.byName(stateName);
        
        Mission mission = new MissionImpl();
        mission.explore(stateToExplore, explorers);
        
        long retired = explorers.stream().filter(e -> e.getEnergy() == 0).count();
        this.exploredStates++;

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retired);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.exploredStates));
        result.append(System.lineSeparator());
        result.append(ConstantMessages.FINAL_EXPLORER_INFO);

        Collection<Explorer> explorers = this.explorerRepository.getCollection();
       
        for (Explorer explorer : explorers) {
            result.append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()));
            result.append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            result.append(System.lineSeparator());
        
            if(explorer.getSuitcase().getExhibits().isEmpty()){
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }
        }
        return result.toString();
    }
}
