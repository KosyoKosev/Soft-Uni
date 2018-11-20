import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XBits {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[8];

        for (int i = 0; i < 8; i++) {
            int number = Integer.parseInt(reader.readLine());
             numbers[i] = number;


        }
    }
}
