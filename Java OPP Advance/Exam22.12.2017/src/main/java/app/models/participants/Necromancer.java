package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public class Necromancer extends AbstractHero{
    public Necromancer() {
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 2) + (super.getDexterity() * 2) + (super.getStrength() * 2);
    }
}
