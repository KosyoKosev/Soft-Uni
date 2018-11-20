package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.contracts.Targetable;
import app.models.actions.BossFight;
import app.models.actions.OneVsOne;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory{
    private static final String ACTION_CLASS_PATH = "app.models.actions.";
    //private Action action;
    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> actionClass = Class.forName(ACTION_CLASS_PATH + actionName);
        Constructor<?> declaredConstructor = actionClass.getDeclaredConstructor();
        Action action = (Action) declaredConstructor.newInstance();

        return action;
//        this.action = null;
//
//        switch (actionName){
//            case "BossFight":
//                this.action = new BossFight();
//                break;
//            case "OneVsOne":
//                this.action = new OneVsOne();
//                break;
//
//        }
//
//        return this.action;

    }
}
