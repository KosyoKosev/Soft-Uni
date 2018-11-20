import java.util.Scanner;

public class ASCIIString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String text = "";

        for (int i = 0;i < n;i++){

            int m = sc.nextInt();
            char convertMToChar = (char)m;
            text += convertMToChar;
        }

        System.out.println(text);
    }
}
