package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        int sum = 0;
        char[] firstString = input[0].toCharArray();
        char[] secondString = input[1].toCharArray();

        if (firstString.length == secondString.length){
            for (int i = 0; i < firstString.length; i++) {
                sum += (int)firstString[i] * (int)secondString[i];
            }
        }else if (firstString.length > secondString.length){
            int index = 0;
            for (int i = 0; i < secondString.length; i++) {
                sum += (int)firstString[i] * (int)secondString[i];
                index ++;
            }
            for (int i = index; i < firstString.length; i++) {
                sum += (int)firstString[i];
            }

        }else {
            int index = 0;
            for (int i = 0; i < firstString.length; i++) {
                sum += (int)firstString[i] * (int)secondString[i];
                index ++;
            }
            for (int i = index; i < secondString.length; i++) {
                sum += (int)secondString[i];
            }
        }
        System.out.println(sum);
    }
}
