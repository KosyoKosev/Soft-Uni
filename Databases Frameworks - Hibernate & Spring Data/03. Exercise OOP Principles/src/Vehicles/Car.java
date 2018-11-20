package Vehicles;

public class Car extends VehicleImpl {
    protected Car(Double fuel, Double consumption) {
        super(fuel, consumption + 0.9);
    }
}
