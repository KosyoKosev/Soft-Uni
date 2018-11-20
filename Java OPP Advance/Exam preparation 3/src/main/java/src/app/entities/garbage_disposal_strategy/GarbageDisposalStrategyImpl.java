package src.app.entities.garbage_disposal_strategy;

import src.app.waste_disposal.contracts.GarbageDisposalStrategy;
import src.app.waste_disposal.contracts.ProcessingData;
import src.app.waste_disposal.contracts.Waste;

public class GarbageDisposalStrategyImpl implements GarbageDisposalStrategy {
    private Waste garbage;

    public GarbageDisposalStrategyImpl(Waste garbage) {
        this.garbage = garbage;
    }

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        return null;
    }
}
