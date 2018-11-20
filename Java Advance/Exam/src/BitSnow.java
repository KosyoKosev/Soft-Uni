import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitSnow {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.valueOf(input[i]);
        }

        int[] corectNumbers = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            corectNumbers[i] = numbers[i];
            for (int j = numbers.length - 1; j >= 0; j--) {
                numbers[i] = numbers[i] | numbers[j];
            }

        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

//        int n = 3313;
//        int m = 312;
//
//        System.out.println(Integer.toBinaryString(n));
//        System.out.printf("%3s\n",Integer.toBinaryString(m));
//        System.out.println(Integer.toBinaryString(m | n));
    }
}
