package src.app.entities.wastes;

import src.app.waste_disposal.contracts.Waste;

public abstract class AbstractWaste implements Waste {
    private String name;
    private double VolumePerKg;
    private double weight;

    protected AbstractWaste(String name, double volumePerKg, double weight) {
        this.name = name;
        VolumePerKg = volumePerKg;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.VolumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
