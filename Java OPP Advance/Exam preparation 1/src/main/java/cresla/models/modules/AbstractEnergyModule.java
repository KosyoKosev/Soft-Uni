package cresla.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule{

    private int energyOutput;

    AbstractEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput(){
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d\n" +
                "Energy Output: %d\n", this.getClass().getSimpleName(), super.getId(), this.energyOutput);
    }
}
