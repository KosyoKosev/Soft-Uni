package interfices;

public interface Target {
    public int getHealth();

    public void takeAttack(int attackPoints);

    public int giveExperience();

    public boolean isDead();
}
