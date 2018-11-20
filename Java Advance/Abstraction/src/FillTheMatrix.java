import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] numbers = new int[n][n];
        int counter = 1;
        if (pattern.equals("A")){
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers[i].length; j++) {
                    numbers[j][i] = counter;
                    counter++;
                }
            }

            printMatrix(numbers);
        }else {
            for (int col = 0; col < numbers.length; col++) {

                if (col % 2 != 0){
                    for (int row = numbers[col].length - 1; row >= 0 ; row--) {
                        numbers[row][col] = counter;
                        counter++;
                    }
                }else {
                    for (int row = 0; row < numbers[col].length; row++) {
                        numbers[row][col] = counter;
                        counter++;
                    }
                }
            }

            printMatrix(numbers);
        }
    }

    private static void printMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
