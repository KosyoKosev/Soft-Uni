package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {
   // private Targetable targetable;
    private static final String PARTICIPANT_CLASS_PATH = "app.models.participants.";
    @Override
    public  Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        this.targetable = null;
//
//        switch (className){
//            case "Boss":
//                this.targetable = new Boss();
//                this.targetable.setName(name);
//                break;
//            case "Warrior":
//                this.targetable = new Warrior();
//                this.targetable.setName(name);
//                break;
//            case "Wizard":
//                this.targetable = new Wizard();
//                this.targetable.setName(name);
//                break;
//            case "BNecromancer":
//                this.targetable = new Necromancer();
//                this.targetable.setName(name);
//                break;
//        }
//
//        return this.targetable;

        Class<?> participantClass = Class.forName(PARTICIPANT_CLASS_PATH + className);
        Constructor<?> declaredConstructor = participantClass.getDeclaredConstructor();
        Targetable targetable = (Targetable) declaredConstructor.newInstance();
        targetable.setName(name);

        return targetable;
    }
}
