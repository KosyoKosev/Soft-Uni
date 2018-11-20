package src.app.entities.wastes;

import src.app.waste_disposal.contracts.Waste;

public class RecyclableGarbage extends AbstractWaste {

    public RecyclableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
