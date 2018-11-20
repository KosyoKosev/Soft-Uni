import java.util.Scanner;

public class ReverseCharacters {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String ch1 = sc.nextLine();
        String ch2 = sc.nextLine();
        String ch3 = sc.nextLine();

        String result = ch3 + ch2 + ch1;
        System.out.println(result);
    }
}
