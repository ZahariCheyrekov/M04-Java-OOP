package M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.players;

import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.models.guns.Gun;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.repositories.GunRepository;
import M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.repositories.interfaces.Repository;

import static M04_JavaOOP.ExamPreparation.Exam19Dec2020.viceCity.common.ExceptionMessages.PLAYER_NULL_USERNAME;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    public void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_NULL_USERNAME);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints = Math.max(0, lifePoints - points);
    }
}