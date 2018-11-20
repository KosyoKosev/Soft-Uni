package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class OddAndEvenPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String[] input = reader.readLine().split("\\s+");
        Deque<Integer> numbers = new LinkedList<>();
        if (input.length % 2 == 0){
            for (String s : input) {
                int number = Integer.parseInt(s);
                 numbers.add(number);
            }

            int n = input.length / 2;
            for (int i = 0; i < n; i++) {
                int first = numbers.pop();
                int second = numbers.pop();
                if (first % 2 == 0 && second % 2 == 0){
                    builder.append(String.format("%d, %d -> both are even\n",first, second));
                }else if (first % 2 == 1 && second % 2 == 1){
                    builder.append(String.format("%d, %d -> both are odd\n",first, second));
                }else {
                    builder.append(String.format("%d, %d -> different\n",first, second));
                }
            }
            System.out.print(builder.toString());
        }else {
            System.out.println("invalid length");
        }
    }
}
