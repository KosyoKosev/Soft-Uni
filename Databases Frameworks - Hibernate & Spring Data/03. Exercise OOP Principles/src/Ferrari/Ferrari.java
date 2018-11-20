package Ferrari;

public class Ferrari implements Car {
    public static String model = "488-Spider";
    private String driverName;

    public Ferrari(String driverName) {
        this.setDriverName(driverName);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public void brakes() {
        System.out.print("Brakes!");
    }

    @Override
    public void pushTheGasPedal() {
        System.out.print("Zadu6avam sA!");
    }
}
