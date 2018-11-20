import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximalSum {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] parametersMatrix = reader.readLine().split(" ");

        int row = Integer.parseInt(parametersMatrix[0]);
        int col = Integer.parseInt(parametersMatrix[1]);

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int sum = Integer.MIN_VALUE;
        int startRowIndex = 0;
        int startColIndex = 0;
        for (row = 0; row < matrix.length - 2; row++) {
            for (col = 0; col < matrix[row].length - 2; col++) {
                if (sum < (matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2])){
                    sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                            + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                            + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                    startColIndex = col;
                    startRowIndex = row;
                }
            }
        }

        System.out.printf("Sum = %d\n", sum);
        for (int i = startRowIndex; i < startRowIndex + 3; i++) {
            for (int j = startColIndex; j < startColIndex + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
