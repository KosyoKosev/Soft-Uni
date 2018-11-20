import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EqualSums {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int[] numbers = new int[input.length];

        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        if (numbers.length == 0){
            System.out.println("no");
            return;
        }
        if (numbers.length == 1){
            System.out.println(0);
            return;
        }
        if (numbers.length == 2 && numbers[0] == 0 && numbers[1] == 0){
            System.out.println(0);
            return;
        }

        int result = 0;
        boolean isEqual = true;
        for (int i = 1; i < numbers.length; i++) {
            sumRight = 0;
            sumLeft += numbers[i - 1];
            if (numbers.length > 2){
                for (int j = numbers.length - 1; j > i ; j--) {
                    sumRight += numbers[j];
                }
            }
            if (sumLeft == sumRight){
                result = i;
                isEqual = true;
                break;
            }else{
                isEqual = false;
            }
        }
        if (isEqual){
            System.out.println(result);
        }else {
            System.out.println("no");
        }
    }
}
