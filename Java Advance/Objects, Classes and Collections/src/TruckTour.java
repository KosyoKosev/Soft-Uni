import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TruckTour {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String[]> allPumps = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String pump = reader.readLine();
            allPumps.addLast(pump.split(" "));
        }
        int counter = 0;
        while (true){
            Long fuel = 0L;
            boolean found = true;

            for (String[] allPump : allPumps) {
                Long currentFuel = Long.valueOf(allPump[0]);
                Long distance = Long.valueOf(allPump[1]);

                fuel += currentFuel;
                if (fuel < distance){
                    found = false;
                    break;
                }
                fuel -= distance;
            }

            if (found){
                System.out.println(counter);
                break;
            }
            String[] currentPump = allPumps.pop();
            allPumps.addLast(currentPump);
            counter++;
        }
    }
}
