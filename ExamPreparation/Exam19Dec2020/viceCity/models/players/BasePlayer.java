package viceCity.models.players;

import viceCity.common.DataValidator;
import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {

    private String name;
    private int lifePoints;
    private final Repository<Gun> gunRepository;

    private static final int ZERO_HEALTH = 0;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        DataValidator.validateString(name, PLAYER_NULL_USERNAME);
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        DataValidator.validateInt(lifePoints, PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
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
        return this.lifePoints > ZERO_HEALTH;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints = Math.max(ZERO_HEALTH, this.lifePoints - points);
    }
}
