import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Earthquake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<List<Integer>> everythingWaves = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            List<Integer> waves = new LinkedList<>();
            for (int j = 0; j < input.length; j++) {
                waves.add(Integer.valueOf(input[j]));
            }
            everythingWaves.addLast(waves);
        }

        while (!everythingWaves.isEmpty()){
            List<Integer> currentWaves = everythingWaves.pop();
            int firstWave = currentWaves.get(0);
            for (int i = 1; i < currentWaves.size(); i++) {
                if (firstWave < currentWaves.get(i)){
                    everythingWaves.addLast(currentWaves.subList(i, currentWaves.size()));
                    break;
                }
            }
            output.add(firstWave);
        }
        System.out.println(output.size());
        System.out.println(Arrays.toString(output.toArray()).replaceAll("[\\[\\],]", ""));
    }
}
