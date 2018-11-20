package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.participants.Warrior;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OneVsOneTest {
    private Action action;
    private Targetable targetable;

    @Before
    public void initialize(){
        this.action = new OneVsOne();
        this.targetable = Mockito.mock(Warrior.class);
    }

    @Test
    public void printErrorMassege(){
        List<Targetable> targetables = new ArrayList<>();
        targetables.add()
    }

}