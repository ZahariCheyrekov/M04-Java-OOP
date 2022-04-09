package fairyShop.models.helpers;

public class Sleepy extends BaseHelper {

    private static final int ZERO_ENERGY = 0;
    private static final int DECREASE_IN_ENERGY = 15;
    private static final int ENERGY = 50;

    public Sleepy(String name) {
        super(name, ENERGY);
    }

    @Override
    public void work() {
        this.setEnergy(Math.max(ZERO_ENERGY, ENERGY - DECREASE_IN_ENERGY));
    }
}