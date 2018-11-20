import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] palindromes = new int[rows][cols];

        char firstCharacter = 'a';


        for (int row = 0; row < palindromes.length; row++) {
            StringBuilder result = new StringBuilder();
            for (int col = 0; col < palindromes[row].length; col++) {
                char secondCharacter = (char)(firstCharacter + col);
                result.append(firstCharacter);
                result.append(secondCharacter);
                result.append(firstCharacter);
                System.out.print(result + " ");
                result = new StringBuilder();
            }
            System.out.println();
            firstCharacter++;
        }
    }
}
