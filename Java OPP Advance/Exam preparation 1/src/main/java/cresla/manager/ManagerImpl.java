package cresla.manager;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reactors.CryoReactor;
import cresla.models.reactors.HeatReactor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<Integer, Reactor> reactorMap;
    private Map<Integer, Module> moduleMap;
    private int id;
    private int energyModuleCounter;
    private int absorbingModuleCounter;
    private int cryoReactorCounter;
    private int heatReactorCounter;

    public ManagerImpl() {
        this.reactorMap = new HashMap<>();
        this.moduleMap = new HashMap<>();
        this.id = 1;
        this.energyModuleCounter = 0;
        this.absorbingModuleCounter = 0;
        this.cryoReactorCounter = 0;
        this.heatReactorCounter = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Container container = new ModuleContainer(Integer.valueOf(arguments.get(2)));
        if ("Cryo".equals(arguments.get(0))){
            this.reactorMap.put(this.id, new CryoReactor(container, this.id, Integer.valueOf(arguments.get(1))));
            this.cryoReactorCounter++;
        }else {
            this.reactorMap.put(this.id, new HeatReactor(container, this.id, Integer.valueOf(arguments.get(1))));
            this.heatReactorCounter++;
        }
        return String.format("Created %s Reactor - %d\n", arguments.get(0), this.id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int id = Integer.valueOf(arguments.get(0));
        switch (arguments.get(1)){
            case "CryogenRod":
                EnergyModule energyModule = new CryogenRod(this.id, Integer.valueOf(arguments.get(2)));
                this.reactorMap.get(id).addEnergyModule(energyModule);
                this.moduleMap.put(this.id, energyModule);
                this.energyModuleCounter++;
                break;
            case "CooldownSystem":
                AbsorbingModule absorbingModule1 = new CooldownSystem(this.id, Integer.valueOf(arguments.get(2)));
                this.reactorMap.get(id).addAbsorbingModule(absorbingModule1);
                this.moduleMap.put(this.id, absorbingModule1);
                this.absorbingModuleCounter++;
                break;
            case "HeatProcessor":
                AbsorbingModule absorbingModule = new HeatProcessor(this.id, Integer.valueOf(arguments.get(2)));
                this.reactorMap.get(id).addAbsorbingModule(absorbingModule);
                this.moduleMap.put(this.id, absorbingModule);
                this.absorbingModuleCounter++;
                break;
        }
        return String.format("Added %s - %d to Reactor - %d\n",arguments.get(1), this.id++, id);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int targetId = Integer.valueOf(arguments.get(0));
        if (reactorMap.containsKey(targetId)){
            return reactorMap.get(targetId).toString();
        }else {
            return moduleMap.get(targetId).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergy = reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalEnergyOutput()).sum();
        long totalHeat = reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();
        return String.format("Cryo Reactors: %d\n" +
                "Heat Reactors: %d\n" +
                "Energy Modules: %d\n" +
                "Absorbing Modules: %d\n" +
                "Total Energy Output: %d\n" +
                "Total Heat Absorbing: %d\n", this.cryoReactorCounter, this.heatReactorCounter, this.energyModuleCounter,
                this.absorbingModuleCounter, totalEnergy, totalHeat);
    }
}
