import java.util.Scanner;

public class IntegerToHexAndBinary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int decimalNumber = sc.nextInt();

        String hex = String.format("%x", decimalNumber).toUpperCase();

        System.out.println(hex);
        System.out.println(toBin(decimalNumber));
    }

    private static String toBin(int number) {

        String result = "";

        while (number > 0){
            int mod = number % 2;
            result = mod + result;

            number /= 2;
        }
        return result;
    }

}
