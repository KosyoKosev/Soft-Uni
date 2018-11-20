import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> result = new ArrayList<>();

        String input = sc.nextLine();

        String[] arr = input.split("\\s+");

        int[] number = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            number[i] = Integer.parseInt(arr[i]);
        }

        int startElement = number[0];
        int lenght = 1;
        int bestElement = number[0];
        int bestLenght = 1;

        for (int i = 1; i < number.length; i++) {

            int element = number[i - 1];

            if (number[i] > element ){
                result.add(element);
                lenght++;

            }else {
                element = number[i];
                result = new ArrayList<>();
            }

            if (i == number.length - 1 && number[i] > element){
                result.add(number[i]);
            }
        }

        for (Integer item: result){
            System.out.print(item + " ");
        }
    }
}
