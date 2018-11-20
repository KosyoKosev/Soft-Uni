import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Earthquake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Integer> output = new ArrayList<>();
        ArrayDeque<List<Integer>> seismicity = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] lineFromNumbers = reader.readLine().split(" ");
            List<Integer> numbers = new ArrayList<>();
            for (String lineFromNumber : lineFromNumbers) {
                numbers.add(Integer.parseInt(lineFromNumber));
            }
            seismicity.addLast(numbers);
        }

        while (!seismicity.isEmpty()){
            List<Integer> currentNumbers = seismicity.pop();
            int wave = currentNumbers.get(0);
            for (int i = 1; i < currentNumbers.size(); i++) {
                if (wave < currentNumbers.get(i)){
                    seismicity.addLast(currentNumbers.subList(i, currentNumbers.size()));
                    break;
                }
            }
            output.add(wave);
        }

        System.out.println(output.size());
        System.out.println(Arrays.toString(output.toArray()).replaceAll("[\\[\\],]",""));
    }
}
