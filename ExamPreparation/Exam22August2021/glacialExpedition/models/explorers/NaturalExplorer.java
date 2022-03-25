package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double ENERGY = 60;
    private static final double DECREASE_IN_ENERGY = 7;
    private static final double ZERO_ENERGY = 0;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        if (getEnergy() <= DECREASE_IN_ENERGY) {
            super.setEnergy(ZERO_ENERGY);
        } else {
            super.setEnergy(this.getEnergy() - DECREASE_IN_ENERGY);
        }
    }
}
