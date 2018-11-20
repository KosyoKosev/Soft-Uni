package exam;

import exam.core.HealthManager;
import exam.entities.organism.Organism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HealthManager healthManager = new HealthManager();



        String input = reader.readLine();

        while (!input.equals("BEER IS COMING")){

            String[] split = input.split("\\s+");
            String command = split[0];

            switch (command){
                case "checkCondition":
                case "createOrganism":
                    String organismName = split[1];
                    healthManager.createOrganism(organismName);
                case "addCluster":
                case "addCell":
                case "activateCluster":
            }

            input = reader.readLine();
        }
    }
}
