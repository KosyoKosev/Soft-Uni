import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stones = new ArrayDeque<>();
        int counter = 0;

        String[] input = reader.readLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            stones.addLast(Integer.valueOf(input[i]));
        }

        String readLine = reader.readLine();

        while (!"Revision".equals(readLine)){

            String[] split = readLine.split("\\s+");
            String command = split[0];
            int diapason = Integer.valueOf(split[2]);

            if ("Apply".equals(command)){
                if (stones.size() > 0){
                    if (stones.size() <= diapason){
                        diapason = stones.size();
                    }
                    for (int i = 0; i < diapason; i++) {
                        int currentStone = stones.pop() - 1;
                        if (currentStone != 0){
                            stones.addLast(currentStone);
                        }else {
                            counter++;
                        }
                    }
                }
            }else {
                if (counter > 0) {
                    counter--;
                    stones.addLast(diapason);
                }
            }

            readLine = reader.readLine();
        }

        int n = stones.size();
        for (int i = 0; i < n; i++) {
            int currentStone = stones.pop();
            System.out.print(currentStone + " ");

        }
        System.out.println();
        System.out.println(counter);
    }
}
