package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.DoublePredicate;

public class FormattingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);
        String binaryFormatA = Integer.toBinaryString(a);
        int n = 10 - binaryFormatA.length();
        if (binaryFormatA.length() < 10){
            for (int i = 0; i < n; i++) {
                binaryFormatA = "0" + binaryFormatA;
            }
        }

        System.out.printf("|%-10X|%s|%10.2f|%-10.3f|",a,binaryFormatA,b,c);
    }
}
