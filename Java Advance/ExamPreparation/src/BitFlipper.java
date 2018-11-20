import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BitFlipper {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine());

        String binaryNumberString = number.toString(2);

        int count = binaryNumberString.length();
        if (count < 64){
            for (int i = 0; i < 64 - count; i++) {
                binaryNumberString = "0" + binaryNumberString;
            }
        }

        char[] chars = binaryNumberString.toCharArray();

        StringBuilder stringResult = new StringBuilder();

        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == chars[i + 1] && chars[i] == chars[i + 2]){
                if (chars[i] == '1'){
                    chars[i] = '0';
                    chars[i + 1] = '0';
                    chars[i + 2] = '0';
                    i += 2;
                }else {
                    chars[i] = '1';
                    chars[i + 1] = '1';
                    chars[i + 2] = '1';
                    i += 2;
                }
            }
        }

        for (char aChar : chars) {
            stringResult.append(aChar);
        }

        BigInteger result = new BigInteger(stringResult.toString(), 2);

        System.out.println(result);
    }
}
