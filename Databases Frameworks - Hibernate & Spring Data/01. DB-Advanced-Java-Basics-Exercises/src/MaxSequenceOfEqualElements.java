import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] arr = input.split(" ");

        String element = arr[0];
        int lenght = 1;
        String bestElement = arr[0];
        int bestLenght = 1;

        for (int i = 1; i < arr.length; i++) {


            if (arr[i].equals(element)){
                lenght++;

                if (lenght > bestLenght){
                    bestLenght = lenght;
                    bestElement = element;
                }
            }else {
                element = arr[i];
                lenght = 1;
            }
        }

        for (int i = 0; i < bestLenght; i++) {
            System.out.print(bestElement + " ");
        }
    }
}
