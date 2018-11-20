package NumberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = reader.readLine().toCharArray();

        String[] decimalNumber = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            decimalNumber[i] = String.valueOf(input[i]);
        }

        printsAllItsDigitsInReversedOrder(decimalNumber);
    }

    public static void printsAllItsDigitsInReversedOrder(String[] number) {
        List<String> result = new ArrayList<>();

        for (int i = number.length - 1; i >= 0; i--) {

            result.add(number[i]);
        }

        String decimalNumber = String.join("", result);
        System.out.println(decimalNumber);
    }
}
