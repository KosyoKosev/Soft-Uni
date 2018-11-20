import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char input = sc.next().charAt(0);

        boolean isNumber = Character.isDigit(input);

        if (isNumber){
            System.out.println("digit");
        }else if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u' ) {
            System.out.println("vowel");
        }else {
            System.out.println("other");
        }
    }
}
