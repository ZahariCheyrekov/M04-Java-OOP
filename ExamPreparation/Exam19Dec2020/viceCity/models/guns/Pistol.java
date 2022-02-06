package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.guns;

public class Pistol extends BaseGun {
    private final static int BULLETS_PER_BARREL = 10;
    private static int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            reload();
        }

        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 1);
        }
        return 1;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        setBulletsPerBarrel(BULLETS_PER_BARREL);
    }
}