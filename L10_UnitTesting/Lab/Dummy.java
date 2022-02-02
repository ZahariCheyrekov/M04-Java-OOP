package M04_JavaOOP.L10_UnitTesting.Lab;

public class Dummy implements Target {

    private int health;
    private int experience;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
