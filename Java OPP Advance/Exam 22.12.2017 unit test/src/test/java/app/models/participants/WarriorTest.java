package app.models.participants;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class WarriorTest {
    private Warrior warrior;

    @Before
    public void initialize(){
        this.warrior = new Warrior();
    }

    @Test
    public void testWarriorTakeDamege(){
        this.warrior.takeDamage(5);
        Assert.assertNotEquals(50, warrior.getHealth());
    }

    @Test
    public void testWarriorIsAlive(){
        this.warrior.takeDamage(50);
        Assert.assertNotEquals(true, this.warrior.isAlive());
    }

    @Test
    public void testWarriorLevelUp() throws NoSuchFieldException, IllegalAccessException {

        this.warrior.levelUp();

        Field levelField = Warrior.class.getDeclaredField("level");
        levelField.setAccessible(true);
        Object value = levelField.get(this.warrior);

        Assert.assertNotEquals(50,this.warrior.getHealth());
        Assert.assertNotEquals(4, this.warrior.getDexterity());
        Assert.assertNotEquals(1, this.warrior.getIntelligence());
        Assert.assertNotEquals(1, value);
        System.out.println();
    }

    @Test
    public void testWarriorReceiveReward() throws NoSuchFieldException, IllegalAccessException {
        Field levelField = Warrior.class.getDeclaredField("gold");
        levelField.setAccessible(true);
        Object value = levelField.get(this.warrior);

        this.warrior.receiveReward(5);
        Assert.assertNotEquals(200,value);
        System.out.println();
    }

}