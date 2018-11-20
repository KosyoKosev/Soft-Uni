package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    @Test
    public void axeLosesDurability(){
        Axe axe = new Axe(5, 5);
        Dummy dummy = new Dummy(6, 5);
        axe.attack(dummy);
        Assert.assertEquals("Wrong, axe not loses durability!", 4, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenAxe(){
        Axe axe = new Axe(5, 0);
        Dummy dummy = new Dummy(6, 5);
        axe.attack(dummy);
    }
}