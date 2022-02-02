package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies.units;

public class Swordsman extends AbstractUnit {
    private static final int SWORDSMAN_HEALTH = 40;
    private static final int SWORDSMAN_DAMAGE = 13;

    public Swordsman() {
        super(SWORDSMAN_HEALTH, SWORDSMAN_DAMAGE);
    }
}
