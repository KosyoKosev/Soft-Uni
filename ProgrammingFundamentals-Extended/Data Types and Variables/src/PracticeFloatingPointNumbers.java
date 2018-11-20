import java.math.BigDecimal;

public class PracticeFloatingPointNumbers {
    public static void main(String[] args) {


        String num1 = "3.141592653589793238";
        BigDecimal bdNum1 = new BigDecimal(num1);
        double num2 = 1.60217657;
        String num3 = "7.8184261974584555216535342341";
        BigDecimal bdNum3 = new BigDecimal(num3);

        System.out.println(bdNum1);
        System.out.println(num2);
        System.out.println(bdNum3);
    }
}

