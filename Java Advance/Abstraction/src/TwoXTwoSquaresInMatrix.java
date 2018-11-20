import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoXTwoSquaresInMatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = reader.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = split[j];
            }
        }

        int counter = 0;

        for (row = 0; row < matrix.length - 1; row++) {
            for (col = 0; col < matrix[row].length - 1; col++) {
                if ((matrix[row][col].equals(matrix[row][col + 1])) && (matrix[row][col].equals(matrix[row + 1][col])) &&
                        (matrix[row][col].equals(matrix[row + 1][col + 1]))){
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
