import java.util.Scanner;

public class HelloName {

    public static String regards(String name){

        return "Hello, " + name +"!";
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        String regards = regards(name);

        System.out.println(regards);
    }
}
