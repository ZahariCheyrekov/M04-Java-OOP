package CounterStriker.models.guns;

public class Rifle extends GunImpl {

    private static final int BULLETS_TO_FIRE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_TO_FIRE) {
            return 0;
        }
        super.decreaseBullets(BULLETS_TO_FIRE);
        return BULLETS_TO_FIRE;
    }
}
