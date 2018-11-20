import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Copy    {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> stationCounter = new TreeMap<>();
        Map<String, List<Map<String, Integer>>> stationReport = new TreeMap<>();

        while (true){
            String[] input = reader.readLine().split(":");
            if ("Recruit".equals(input[0])){
                break;
            }

            String name = input[0];
            int facilityNumber = Integer.parseInt(input[1]);
            String stationName = input[2];
            boolean isValidName = isValidStationName(stationName);
            if (isValidName){
                stationCounter.putIfAbsent(stationName, 0);
                stationCounter.put(stationName, (stationCounter.get(stationName) + 1));

                String personData = String.format("###%s - %s", name, facilityNumber);
                stationReport.putIfAbsent(stationName, new LinkedList<>());
                Map<String, Integer> names = new TreeMap<>();
                names.put(name, facilityNumber);
                stationReport.get(stationName).add(names);

            }
        }
        StringBuilder result = new StringBuilder();
        stationCounter.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(v -> {
                    result.append("The ").append(v.getKey()).append(" has ").append(v.getValue()).append(" DHARMA recruits in it.\n");
                });

        // stationReport.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        String command = reader.readLine();

        if ("DHARMA Initiative".equals(command)){
            System.out.println(result);
        }else {
//            if (isValidStationName(command)){
//                switch (command){
//                    case "Hydra":
//                        if (stationReport.get(command).size() > 0){
//                            System.out.println("The Hydra station: Zoological Research.");
//                            for (String s : stationReport.get(command)) {
//                                System.out.println(s);
//                            }
//                        }else {
//                            System.out.println("The Hydra station: Zoological Research.No recruits.");
//                        }
//                        break;
//                    case "Arrow":
//                        if (stationReport.get(command).size() > 0){
//                            System.out.println("The Arrow station: Development of defensive strategies, and Intelligence gathering.");
//                            for (String s : stationReport.get(command)) {
//                                System.out.println(s);
//                            }
//                        }else {
//                            System.out.println("The Arrow station: Development of defensive strategies, and Intelligence gathering.No recruits.");
//                        }
//                        break;
//                    case "Flame":
//                        if (stationReport.get(command).size() > 0){
//                            System.out.println("The Flame station: Communication.");
//                            for (String s : stationReport.get(command)) {
//                                System.out.println(s);
//                            }
//                        }else {
//                            System.out.println("The Flame station: Communication.No recruits.");
//                        }
//                        break;
//                    case "Pearl":
//                        if (stationReport.get(command).size() > 0){
//                            System.out.println("The Pearl station: Psychological Research and/or Observation.");
//                            for (String s : stationReport.get(command)) {
//                                System.out.println(s);
//                            }
//                        }else {
//                            System.out.println("The Pearl station: Psychological Research and/or Observation.No recruits.");
//                        }
//                        break;
//                    case "Orchid":
//                        if (stationReport.get(command).size() > 0){
//                            System.out.println("The Orchid station: Space-time manipulation research, disguised as a Botanical station.");
//                            for (String s : stationReport.get(command)) {
//                                System.out.println(s);
//                            }
//                        }else {
//                            System.out.println("The Orchid station: Space-time manipulation research, disguised as a Botanical station.No recruits.");
//                        }
//                        break;
//                }
//            }else {
//                System.out.println("DHARMA Initiative does not have such a station!");
//            }
        }

    }

    private static boolean isValidStationName(String stationName) {
        boolean isValid = false;
        switch (stationName){
            case "Hydra":
                isValid = true;
                break;
            case "Arrow":
                isValid = true;
                break;
            case "Flame":
                isValid = true;
                break;
            case "Pearl":
                isValid = true;
                break;
            case "Orchid":
                isValid = true;
                break;
        }
        return isValid;
    }
}
