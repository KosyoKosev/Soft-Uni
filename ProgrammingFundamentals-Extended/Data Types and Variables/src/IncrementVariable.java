import java.util.Scanner;

public class IncrementVariable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int overflow = 0;

        if (number < 256){
            System.out.println(number);
        }else{
            System.out.printf("%d%nOverflowed %d times",number % 256,number / 256);
        }
    }
}
