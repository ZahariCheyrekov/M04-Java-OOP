package fairyShop.models.helpers;

import fairyShop.models.instruments.Instrument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ExceptionMessages.*;

public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    private static final int ZERO_ENERGY = 0;
    private static final int DECREASE_IN_ENERGY = 10;

    protected BaseHelper(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {
        if (energy < ZERO_ENERGY) {
            throw new IllegalArgumentException(HELPER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public void work() {
        this.energy = Math.max(ZERO_ENERGY, this.energy - DECREASE_IN_ENERGY);
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > ZERO_ENERGY;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        List<Instrument> notBrokenInstruments = this.instruments
                .stream()
                .filter(instrument -> !instrument.isBroken())
                .collect(Collectors.toList());

        info.append(String.format("Name: %s", this.name)).append(System.lineSeparator());
        info.append(String.format("Energy: %d", this.energy)).append(System.lineSeparator());
        info.append(String.format("Instruments: %d not broken left", notBrokenInstruments.size())).append(System.lineSeparator());

        return info.toString().trim();
    }
}