package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss implements Targetable {

    private String name;
    private double health;
    private double gold;
    private double damage;
    private boolean isAlive;

    public Boss() {
        this.setHealth(Config.BOSS_HEALTH);
        this.gold = Config.BOSS_GOLD;
        this.damage = Config.BOSS_DAMAGE;
        this.isAlive = true;
    }

    @Override
    public String attack(Targetable target) {

        return "";
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.health - damage);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {

    }

    @Override
    public void receiveReward(double reward) {

    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public boolean isAlive() {
        if (this.health <= 0){
            this.isAlive = false;
        }
        return this.isAlive;
    }
}
