package viceCity.models.guns;

import viceCity.common.DataValidator;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;

    private static final int ZERO_BULLETS = 0;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
    }

    private void setName(String name) {
        DataValidator.validateString(name, NAME_NULL);
        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        DataValidator.validateInt(bulletsPerBarrel, BULLETS_LESS_THAN_ZERO);
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {
        DataValidator.validateInt(totalBullets, TOTAL_BULLETS_LESS_THAN_ZERO);
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.bulletsPerBarrel > ZERO_BULLETS || this.totalBullets > ZERO_BULLETS;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }
}
