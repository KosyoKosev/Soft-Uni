import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class TheSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> theNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> secondNumbers = new ArrayDeque<>();
        List<Integer> result = new LinkedList<>();

        String[] firstInput = reader.readLine().split(" ");
        String[] secondInput = reader.readLine().split(" ");

        for (String s : firstInput) {
            int number = Integer.parseInt(s);
            theNumbers.addLast(number);
        }

        for (String s : secondInput) {
            int number = Integer.parseInt(s);
            secondNumbers.addLast(number);
        }

        while (result.size() < 6){
            int firstNumberFromTheNumbers = theNumbers.peek();
            int firstNumberFromSecondNumbers = secondNumbers.pop();

            if (firstNumberFromSecondNumbers % firstNumberFromTheNumbers == 0){
                result.add(firstNumberFromSecondNumbers);
                theNumbers.remove();
            }else {
                firstNumberFromSecondNumbers++;
                secondNumbers.addLast(firstNumberFromSecondNumbers);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1){
                sb.append(result.get(i));
                sb.append(", ");
            }else {
                sb.append(result.get(i));
            }
        }
        System.out.println(sb.toString());
    }
}
