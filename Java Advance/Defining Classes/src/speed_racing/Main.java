package speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        Car car = null;
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");

            String model = line[0];
            double fuelAmount = Double.parseDouble(line[1]);
            double costFuelForKm = Double.parseDouble(line[2]);

            car = new Car(model, fuelAmount, costFuelForKm);

            if (!cars.containsKey(model)) {
                cars.put(model, car);
            }
        }

        String line = reader.readLine();

        while (!line.equals("End")){
            String[] split = line.split("\\s+");
            String model = split[1];
            double amountForKm = Double.parseDouble(split[2]);

            cars.get(model).drive(amountForKm);

            line = reader.readLine();
        }

        cars.values().forEach(System.out::println);
    }
}
