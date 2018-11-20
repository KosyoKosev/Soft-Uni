package rpg_lab;

import interfices.Target;
import interfices.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    private static final int TARGET_GIVE_EXPERIENCE = 5;
    private static final boolean TARGET_IS_DEAD = true;

    @Test
    public void addHeroExperienceWhenKillTarget(){
        Target mockitoTarget = Mockito.mock(Target.class);
        Mockito.when(mockitoTarget.giveExperience()).thenReturn(TARGET_GIVE_EXPERIENCE);
        Mockito.when(mockitoTarget.isDead()).thenReturn(TARGET_IS_DEAD);

        Weapon mockitoWeapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Gosho",mockitoWeapon);

        hero.attack(mockitoTarget);
        Assert.assertEquals("Wrong hore expirience.", 5, hero.getExperience());
    }

}