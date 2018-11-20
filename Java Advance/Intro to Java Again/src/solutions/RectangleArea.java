package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RectangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] split = input.split("\\s+");

        double number1 = Double.parseDouble(split[0]);
        double number2 = Double.parseDouble(split[1]);
        double sum = number1 * number2;

        System.out.println(String.format("%.2f",sum));
    }
}
