import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int sumPrimaryDiagonal = 0;
        int sumSecondaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col){
                    sumPrimaryDiagonal += matrix[row][col];
                }

                if ((row == matrix.length - 1 && col == 0) || (row == 0 && col == matrix.length - 1) || (col == matrix.length - 1 - row)){
                    sumSecondaryDiagonal += matrix[row][col];
                }
            }
        }

        int difference = Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal);

        System.out.println(difference);
    }
}
