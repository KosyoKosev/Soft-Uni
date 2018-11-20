import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteParty {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(reader.readLine());
            numbers[i] = b;
        }

        String input = reader.readLine();

        while (!input.equals("party over")){
            String[] split = input.split(" ");
            String command = split[0];
            int index = Integer.parseInt(split[1]);

            switch (command){
                case "-1":

                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] ^ (1 << index);
                    }
                    break;
                case "0":

                    int mask = ~(1 << index);

                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask;
                    }
                    break;
                case "1":

                    mask = (1 << index);

                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask;

                    }
                    break;
            }

            input = reader.readLine();
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
