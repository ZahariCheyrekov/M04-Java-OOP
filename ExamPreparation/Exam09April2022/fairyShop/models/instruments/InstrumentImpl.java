package fairyShop.models.instruments;

import static fairyShop.common.ExceptionMessages.*;

public class InstrumentImpl implements Instrument {

    private int power;

    private static final int ZERO_POWER = 0;
    private static final int DECREASE_IN_POWER = 10;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) {
        if (power < ZERO_POWER) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        this.power = Math.max(ZERO_POWER, this.power - DECREASE_IN_POWER);
    }

    @Override
    public boolean isBroken() {
        return this.power == ZERO_POWER;
    }
}