package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FirstOddOrEvenElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNumbers = reader.readLine().split("\\s+");
        String[] inputCommand = reader.readLine().split("\\s+");

        int lengthNumbers = Integer.parseInt(inputCommand[1]);
        String oddOrEven = inputCommand[2];
        List<Integer> resultNumbers = new ArrayList<>();
        int[] numbers = new int[inputNumbers.length];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        switch (oddOrEven) {
            case "odd":
                for (int number : numbers) {
                    if (number % 2 != 0){
                        resultNumbers.add(number);
                        if (resultNumbers.size() == lengthNumbers){
                            break;
                        }
                    }
                }
                break;
            case "even":
                for (int number : numbers) {
                    if (number % 2 == 0){
                        resultNumbers.add(number);
                        if (resultNumbers.size() == lengthNumbers){
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
        for (Integer number : resultNumbers) {
            builder.append(number).append(" ");
        }
        System.out.println(builder.toString().trim());
    }
}
