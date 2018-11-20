package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitTheTarget {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int number = Integer.parseInt(reader.readLine());

        if (number < 21){
            for (int i = 1; i < number; i++) {
                for (int j = 1; j < number; j++) {
                    if (i + j == number){
                        builder.append(String.format("%d + %d = %d\n", i, j, number));
                    }
                }
            }

            for (int i = 1; i < 21; i++) {
                for (int j = 1; j < 21; j++) {
                    if (i - j == number){
                        builder.append(String.format("%d - %d = %d\n", i, j, number));
                    }
                }
            }
        }else {
            for (int i = 1; i < 21; i++) {
                for (int j = 1; j < 21; j++) {
                    if (i + j == number){
                        builder.append(String.format("%d + %d = %d\n", i, j, number));
                    }
                }
            }
        }
        System.out.print(builder.toString());
    }
}
