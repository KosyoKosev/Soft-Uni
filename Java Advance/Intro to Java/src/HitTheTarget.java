import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitTheTarget {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                if (i + j == n){
                    System.out.printf("%d + %d = %d\n", i, j, n);
                }
            }
        }

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                if (i - j == n){
                    System.out.printf("%d - %d = %d\n", i, j, n);
                }
            }
        }
    }
}
