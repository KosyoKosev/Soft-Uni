import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitStringIn20Chars {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = reader.readLine().toCharArray();
        boolean is = false;
        for (int i = 0; i < 20; i++) {
            if (input.length < 20){
                for (int j = 0; j < input.length; j++) {
                    System.out.print(input[j]);
                }
                for (int j = 0; j < 20 - input.length; j++) {
                    System.out.print("*");
                }
                break;
            }
            System.out.print(input[i]);
        }
    }
}
