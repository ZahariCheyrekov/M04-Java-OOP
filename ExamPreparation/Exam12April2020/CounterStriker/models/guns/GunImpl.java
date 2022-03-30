package CounterStriker.models.guns;

import CounterStriker.common.DataValidator;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun {

    private String name;
    private int bulletsCount;

    private static final int NO_BULLETS = 0;
    private static final int BULLETS_PER_FIRE = 1;

    protected GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    private void setName(String name) {
        DataValidator.validateString(name, INVALID_GUN_NAME);
        this.name = name;
    }

    protected void setBulletsCount(int bulletsCount) {
        DataValidator.validateInt(bulletsCount, INVALID_GUN_BULLETS_COUNT);
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        if (this.bulletsCount >= BULLETS_PER_FIRE) {
            this.bulletsCount -= BULLETS_PER_FIRE;
            return BULLETS_PER_FIRE;
        }

        return NO_BULLETS;
    }
}
