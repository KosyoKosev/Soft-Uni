import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b =sc.nextDouble();
        double area = a * b;

        System.out.printf("%.2f",area);
    }
}
