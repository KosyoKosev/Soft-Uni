import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int operandOne = Integer.parseInt(sc.nextLine());
        String operator = sc.nextLine();

        int operandTwo = Integer.parseInt(sc.nextLine());
        int result = 0;

        switch (operator){
            case "+":
                result = operandOne + operandTwo;
                System.out.printf("%d %s %d = %d",operandOne,operator,operandTwo,result);
                break;
            case "-":
                result = operandOne - operandTwo;
                System.out.printf("%d %s %d = %d",operandOne,operator,operandTwo,result);
                break;
            case "/":
                result = operandOne / operandTwo;
                System.out.printf("%d %s %d = %d",operandOne,operator,operandTwo,result);
                break;
            case "*":
                result = operandOne * operandTwo;
                System.out.printf("%d %s %d = %d",operandOne,operator,operandTwo,result);
                break;

        }
    }
}
