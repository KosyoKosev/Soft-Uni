import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        double b = Double.parseDouble(sc.next());
        double c = Double.parseDouble(sc.next());

        String binaryA = Integer.toBinaryString(a);

        int binary = Integer.parseInt(binaryA);

        System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|",a,binary,b,c);
    }
}
