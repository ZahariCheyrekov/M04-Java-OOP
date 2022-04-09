package fairyShop.models.presents;

import static fairyShop.common.ExceptionMessages.*;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;

    private static final int ZERO_ENERGY = 0;
    private static final int DECREASE_IN_ENERGY = 10;

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergyRequired(int energyRequired) {
        if (energyRequired < ZERO_ENERGY) {
            throw new IllegalArgumentException(PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    @Override
    public boolean isDone() {
        return this.energyRequired == ZERO_ENERGY;
    }

    @Override
    public void getCrafted() {
        this.energyRequired = Math.max(ZERO_ENERGY, this.energyRequired - DECREASE_IN_ENERGY);
    }
}