package BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifible> identifibles = new ArrayList<>();
        List<Birthable> birthables = new ArrayList<>();

        while (true){
            String input = reader.readLine();

            if (input.equals("End")){
                break;
            }

            String[] split = input.split(" ");
//            String name = split[0];
//
//            if (split.length == 2){
//                String id = split[1];
//                Identifible robot = new RobotImpl(id,name);
//                identifibles.add(robot);
//            }else {
//                int age = Integer.parseInt(split[1]);
//                String id = split[2];
//                Identifible citizen = new CitizenImpl(id,name,age);
//                identifibles.add(citizen);
//            }
            switch (split[0]){
                case "Citizen":
                    String name = split[1];
                    int age = Integer.parseInt(split[2]);
                    String id = split[3];
                    String birthday = split[4];
                    Birthable person = new CitizenImpl(id,name,age,birthday);
                    birthables.add(person);
                    Identifible citizen = new CitizenImpl(id,name,age,birthday);
                    identifibles.add(citizen);
                    break;
                case "Pet":
                    String namePet = split[1];
                    String birthdayPet = split[2];
                    Pet pet = new PetImpl(namePet,birthdayPet);
                    birthables.add(pet);
                    break;
                case "Robot":
                    String nameRobot = split[1];
                    String idRobot = split[2];
                    Robot robot = new RobotImpl(idRobot, nameRobot);
                    identifibles.add(robot);
                    break;
            }
        }

        String year = reader.readLine();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthday().endsWith(year)){
                System.out.println(birthable.getBirthday());
            }
        }

//        String validId = reader.readLine();
//
//        for (Identifible identifible : identifibles) {
//            if (identifible.getId().endsWith(validId)){
//                System.out.println(identifible.getId());
//            }
//        }

    }
}
