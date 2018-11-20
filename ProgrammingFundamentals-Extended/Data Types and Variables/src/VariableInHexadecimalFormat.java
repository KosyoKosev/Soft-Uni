import java.util.Scanner;

public class VariableInHexadecimalFormat {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String hexadecimal = sc.nextLine();

        int outputDecimal = Integer.parseInt(hexadecimal,16);

        System.out.println(outputDecimal);
    }
}
