package LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        String[] numbersName = new String[]{"zero", "one", "two", "three" , "four", "five", "six", "seven",
        "eight", "nine"};

        int index = input % 10;

        System.out.println(numbersName[index]);
    }
}
