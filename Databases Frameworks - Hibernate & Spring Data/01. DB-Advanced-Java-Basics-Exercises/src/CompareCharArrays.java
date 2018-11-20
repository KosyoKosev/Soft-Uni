import java.util.Arrays;
import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        String[] ar1 = input1.split(" ");
        String[] ar2 = input2.split(" ");

        String first = String.join("", Arrays.asList(ar1));
        String second = String.join("", Arrays.asList(ar2));

        if (first.compareTo(second) <= 0){
            System.out.println(first);
            System.out.println(second);
        }else {
            System.out.println(second);
            System.out.println(first);
        }
    }
}
