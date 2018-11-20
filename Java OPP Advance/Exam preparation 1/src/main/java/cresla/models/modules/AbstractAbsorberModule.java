package cresla.models.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbstractAbsorberModule extends AbstractModule implements AbsorbingModule {

    private int heatAbsorbing;

    AbstractAbsorberModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return String.format("%s Module - %d\n" +
                "Heat Absorbing: %d\n", this.getClass().getSimpleName(), super.getId(), this.heatAbsorbing);
    }
}
