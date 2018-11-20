import java.util.Scanner;

public class FloatOrInteger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double number = sc.nextDouble();
        System.out.println(Math.round(number));
    }
}
