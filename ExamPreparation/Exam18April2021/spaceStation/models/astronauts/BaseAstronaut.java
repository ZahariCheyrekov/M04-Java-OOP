package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.oxygen = Math.max(0, this.oxygen - 10);
    }

    @Override
    public String toString() {

        StringBuilder astronautInfo = new StringBuilder();

        astronautInfo
                .append(String.format(REPORT_ASTRONAUT_NAME, this.name))
                .append(System.lineSeparator());

        astronautInfo
                .append(String.format(REPORT_ASTRONAUT_OXYGEN, this.oxygen))
                .append(System.lineSeparator());

        if (bag.getItems().isEmpty()) {
            astronautInfo.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none"));
        } else {

            String bagItems = String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER,
                    this.bag.getItems());

            astronautInfo.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, bagItems));
        }

        astronautInfo.append(System.lineSeparator());

        return astronautInfo.toString().trim();
    }
}
