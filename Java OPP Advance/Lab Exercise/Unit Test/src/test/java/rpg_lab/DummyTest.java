package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void losesHealthDummy() {
        Dummy dummy = new Dummy(2, 2);
        Axe axe = new Axe(1,2);
        axe.attack(dummy);
        Assert.assertEquals("Wrong dummy not lose health.",1, dummy.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void deadDummy() {
        Dummy dummy = new Dummy(2, 2);
        Axe axe = new Axe(3,2);
        axe.attack(dummy);
        axe.attack(dummy);
    }
}