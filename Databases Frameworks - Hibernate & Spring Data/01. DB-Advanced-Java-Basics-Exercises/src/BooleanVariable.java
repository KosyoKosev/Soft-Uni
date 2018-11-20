import java.util.Scanner;

public class BooleanVariable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        if (command.equals("True")){

            System.out.println("Yes");
        }else {

            System.out.println("No");
        }
    }
}
