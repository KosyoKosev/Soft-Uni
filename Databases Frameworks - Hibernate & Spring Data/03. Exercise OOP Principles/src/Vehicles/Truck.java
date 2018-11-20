package Vehicles;

public class Truck extends VehicleImpl {
    protected Truck(Double fuel, Double consumption) {
        super(fuel, consumption + 1.6);
    }

    @Override
    public void refuel(Double fuel) {
        super.refuel(fuel * 0.95);
    }
}
