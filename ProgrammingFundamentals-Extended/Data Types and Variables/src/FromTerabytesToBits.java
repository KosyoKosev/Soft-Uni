
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FromTerabytesToBits {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");

        Scanner sc = new Scanner(System.in);

        double n = sc.nextDouble();
        BigDecimal bdN = new BigDecimal(n);

        String bits = "8796093022208";
        BigDecimal bdBits= new BigDecimal(bits);


        System.out.println((bdBits.multiply(bdN)));
    }
}
