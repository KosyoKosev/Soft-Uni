import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class DHARMASonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = new LinkedList<>();

        while (true){
            StringBuilder builder = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            String input = reader.readLine();
            if ("Reprogram".equals(input)){
                break;
            }
            long number = Long.parseLong(input);

            String binaryNumber = Long.toBinaryString(number);
            if (binaryNumber.length() < 32){
                for (int i = 32 - binaryNumber.length(); i > 0 ; i--) {
                    sb.append(0);
                }
            }
            sb.append(binaryNumber);
            char[] chars = sb.toString().toCharArray();

            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '1' && chars[i + 1] == '1'){
                    chars[i] = '0';
                    chars[i + 1] = '0';
                    i++;
                }else if (chars[i] == '0' && chars[i + 1] == '0'){
                    chars[i] = '1';
                    chars[i + 1] = '1';
                    i++;
                }
            }

            for (char aChar : chars) {
                builder.append(aChar);
            }

            numbers.add(builder.toString());
        }

        for (String number : numbers) {
            System.out.println(Long.parseLong(number, 2));
        }
    }
}
