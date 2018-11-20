package Vehicles;

public abstract class VehicleImpl implements Vehicle{
    private Double fuel;
    private Double consumption;

    protected VehicleImpl(Double fuel, Double consumption) {
        this.fuel = fuel;
        this.consumption = consumption;
    }

    @Override
    public void drive(Double km) {
        if (this.canTravel(km)){
            fuel -= km * consumption;
        }
    }

    @Override
    public void refuel(Double fuel) {
        this.fuel += fuel;
    }

    @Override
    public boolean canTravel(Double km) {
        if (this.fuel / this.consumption >= km){
            return true;
        }
        return false;
    }

    @Override
    public Double getFuel() {
        return this.fuel;
    }

    @Override
    public Double getConsumption() {
        return this.consumption;
    }
}
