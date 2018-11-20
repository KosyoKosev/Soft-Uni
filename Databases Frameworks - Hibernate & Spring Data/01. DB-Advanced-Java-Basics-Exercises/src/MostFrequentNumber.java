import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class MostFrequentNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> numbers = new LinkedHashMap<>();

        String input = reader.readLine();

        String[] split = input.split("\\s+");

        int[] arr = new int[split.length];

        for (int i = 0; i < split.length ; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        for (int i : arr) {
            if (!numbers.containsKey(i)){
                numbers.put(i, 1);
            }
            numbers.put(i, numbers.get(i) + 1);
        }

        numbers.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(1)
                .forEach(a -> System.out.println(a.getKey()));
    }
}
