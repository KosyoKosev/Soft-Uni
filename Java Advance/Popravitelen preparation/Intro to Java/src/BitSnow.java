import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitSnow {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = numbers.length - 1; i > 0; i--) {
            int firstValue = numbers[i];

            numbers[i] = numbers[i] | numbers[i - 1];
            numbers[i - 1] &= firstValue;

            for (int j = i - 2; j >= 0 ; j--) {
                firstValue = numbers[i];
                numbers[i] = numbers[i] | numbers[j];
                numbers[j] &= firstValue;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
            if (i != numbers.length - 1){
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
