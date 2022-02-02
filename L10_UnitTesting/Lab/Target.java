package M04_JavaOOP.L10_UnitTesting.Lab;

public interface Target {
    int getHealth();
    void takeAttack(int attackPoints);
    boolean isDead();
    int giveExperience();
}