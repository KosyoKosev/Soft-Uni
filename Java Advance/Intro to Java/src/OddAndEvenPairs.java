import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddAndEvenPairs {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] split = reader.readLine().split("\\s+");

        int[] numbers = new int[split.length];

        if (numbers.length % 2 != 0){
            System.out.println("invalid length");

        }else {

            for (int i = 0; i < split.length; i++) {
                numbers[i] = Integer.parseInt(split[i]);
            }

            for (int i = 0; i < numbers.length; i += 2) {

                if (numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0){
                    System.out.printf("%d, %d -> both are even\n", numbers[i], numbers[i + 1]);
                }else if (numbers[i] % 2 != 0 && numbers[i + 1] % 2 != 0){
                    System.out.printf("%d, %d -> both are odd\n", numbers[i], numbers[i + 1]);
                }else {
                    System.out.printf("%d, %d -> different\n", numbers[i], numbers[i + 1]);
                }
            }

        }


    }
}
