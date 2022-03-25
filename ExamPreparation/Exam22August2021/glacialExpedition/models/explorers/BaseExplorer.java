package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;
    private static final double ZERO_ENERGY = 0;
    private static final double DECREASE_IN_ENERGY = 15;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < ZERO_ENERGY) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > ZERO_ENERGY;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        this.energy = Math.max(ZERO_ENERGY, this.energy - DECREASE_IN_ENERGY);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        info.append(String.format(FINAL_EXPLORER_NAME, this.name)).append(System.lineSeparator());
        info.append(String.format(FINAL_EXPLORER_ENERGY, this.energy)).append(System.lineSeparator());
        info.append("Suitcase exhibits: ");

        int exhibitsCount = this.suitcase.getExhibits().size();

        String suitcaseExhibit = exhibitsCount == 0
                ? "None"
                : String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, this.getSuitcase().getExhibits());

        info.append(suitcaseExhibit);

        return info.toString().trim();
    }
}
