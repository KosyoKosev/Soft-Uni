package Vehicles;

public interface Vehicle {
    void drive(Double km);
    void refuel(Double fuel);
    boolean canTravel(Double km);
    Double getFuel();
    Double getConsumption();
}
