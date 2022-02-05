package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers;

import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.suitcases.Carton;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.suitcases.Suitcase;
import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.common.ExceptionMessages;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    @Override
    public void search() {
        this.energy = Math.max(0, this.energy - 15);
    }

    @Override
    public boolean canSearch(){
        return energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    public void setSuitcase(Suitcase suitcase) {
        this.suitcase = suitcase;
    }
}
