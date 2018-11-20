
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DragonArmy {
    private static int DEFAULT_DAMAGE = 45;
    private static int DEFAULT_HEALTH = 250;
    private static int DEFAULT_ARMOR = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, TreeMap<String, int[]>> allDragons = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split(" ");
            String type = split[0];
            String dragonName = split[1];
            int damage = split[2].equals("null") ? DEFAULT_DAMAGE : Integer.valueOf(split[2]);
            int health = split[3].equals("null") ? DEFAULT_HEALTH : Integer.valueOf(split[3]);
            int armor = split[4].equals("null") ? DEFAULT_ARMOR : Integer.valueOf(split[4]);

            if (!allDragons.containsKey(type)){
                allDragons.put(type, new TreeMap<>());
            }
            allDragons.get(type).put(dragonName, new int[]{damage, health, armor});
        }

        for (Map.Entry<String, TreeMap<String, int[]>> dragons : allDragons.entrySet()) {
            calculateAndPrintAverage(dragons.getValue(), dragons.getKey());

            for (Map.Entry<String, int[]> dragonNames: dragons.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragonNames.getKey(),dragonNames.getValue()[0],
                        dragonNames.getValue()[1], dragonNames.getValue()[2] );
            }
        }
    }

    private static void calculateAndPrintAverage(TreeMap<String, int[]> dragonsValue, String color) {
        double damageAverage = 0;
        double healthAverage = 0;
        double armorAverage = 0;

        for (int[] ints : dragonsValue.values()) {
            damageAverage += ints[0];
            healthAverage += ints[1];
            armorAverage += ints[2];
        }

        damageAverage /= dragonsValue.size();
        healthAverage /= dragonsValue.size();
        armorAverage /= dragonsValue.size();

        System.out.printf("%s::(%.2f/%.2f/%.2f)\n", color, damageAverage, healthAverage, armorAverage);
    }
}
