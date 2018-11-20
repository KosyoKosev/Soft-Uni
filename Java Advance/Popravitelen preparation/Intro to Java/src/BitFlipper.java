import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BitFlipper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());
        BigInteger seven = new BigInteger("7");
        BigInteger zero = new BigInteger("0");

        for (int i = 0; i < 62; i++) {
            BigInteger threeDigits = number.shiftRight(61 - i).add(seven);
            if (threeDigits.equals(seven) || threeDigits.equals(zero)){
                number = number.xor(seven.shiftLeft(61 - 1));
                i += 2;
            }
        }
        System.out.println(number);

//        StringBuilder sb = new StringBuilder();
//        String binaryNumber = number.toString(2);
//        if (binaryNumber.length() < 64){
//            for (int i = 64 - binaryNumber.length(); i > 0 ; i--) {
//                sb.append(0);
//            }
//        }
//        sb.append(binaryNumber);
//        char[] chars = sb.toString().toCharArray();
//        for (int i = 0; i < chars.length - 2; i++) {
//            if ((chars[i] == '0') && (chars[i + 1] == '0') && (chars[i + 2] == '0')){
//                chars[i] = '1';
//                chars[i + 1] = '1';
//                chars[i + 2] = '1';
//                i+= 2;
//            }else if ((chars[i] == '1') && (chars[i + 1] == '1') && (chars[i + 2] == '1')){
//                chars[i] = '0';
//                chars[i + 1] = '0';
//                chars[i + 2] = '0';
//                i+= 2;
//            }
//        }
//
//        sb = new StringBuilder();
//
//        for (char aChar : chars) {
//            sb.append(aChar);
//        }
//
//        BigInteger resultNumber = new BigInteger(sb.toString(), 2);
//        System.out.println(resultNumber);
    }
}
