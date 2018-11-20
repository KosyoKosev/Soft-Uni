package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {

        DecimalFormat df = new DecimalFormat("#.#########");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputCar = reader.readLine();
        String inputTruck = reader.readLine();

        String[] splitCar = inputCar.split(" ");
        String[] splitTruck = inputTruck.split(" ");

        double fuelCar = Double.parseDouble(splitCar[1]);
        double consumptionCar = Double.parseDouble(splitCar[2]);
        double fuelTruck = Double.parseDouble(splitTruck[1]);
        double consumptionTruck = Double.parseDouble(splitTruck[2]);

        Vehicle car = new Car(fuelCar, consumptionCar);
        Vehicle truck = new Truck(fuelTruck, consumptionTruck);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String command = reader.readLine();

            String[] splitCommand = command.split(" ");

            String method = splitCommand[0];
            String vehicle = splitCommand[1];

            if (method.equals("Drive")) {
                if (vehicle.equals("Car")) {
                    double km = Double.parseDouble(splitCommand[2]);

                    if (car.canTravel(km)) {
                        car.drive(km);
                        System.out.printf("Car travelled %s km\n", df.format(km));
                    } else {
                        System.out.println("Car needs refueling");
                    }
                } else {
                    double km = Double.parseDouble(splitCommand[2]);

                    if (truck.canTravel(km)) {
                        truck.drive(km);
                        System.out.printf("Truck travelled %s km\n", df.format(km));
                    } else {
                        System.out.println("Truck needs refueling");
                    }
                }
            } else {

                if (splitCommand.length == 3) {
                    if (vehicle.equals("Car")) {
                        double fuel = Double.parseDouble(splitCommand[2]);
                        car.refuel(fuel);
                    } else {
                        double fuel = Double.parseDouble(splitCommand[2]);
                        truck.refuel(fuel);
                    }
                }
            }
        }

        System.out.printf("Car: %.2f\nTruck: %.2f\n", car.getFuel(), truck.getFuel());
    }
}
