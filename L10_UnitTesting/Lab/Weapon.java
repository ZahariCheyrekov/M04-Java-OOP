package M04_JavaOOP.L10_UnitTesting.Lab;

public interface Weapon {
    int getAttackPoints();
    int getDurabilityPoints();
    void attack(Target target);
}