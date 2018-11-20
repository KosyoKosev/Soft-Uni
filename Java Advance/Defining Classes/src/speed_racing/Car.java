package speed_racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double costFuelForKm;
    private double distance = 0;

    public Car(String model, double fuelAmount, double costFuelForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costFuelForKm = costFuelForKm;
    }


    public void drive(double kilometers) {

        if (kilometers * this.costFuelForKm <= this.fuelAmount){
            this.distance += kilometers;
            this.fuelAmount -= kilometers * this.costFuelForKm;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distance);
    }
}
