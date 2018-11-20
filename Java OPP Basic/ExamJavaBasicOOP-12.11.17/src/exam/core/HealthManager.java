package exam.core;

import exam.entities.cells.*;
import exam.entities.cluster.Cluster;
import exam.entities.organism.Organism;

import java.util.*;

public  class HealthManager {
    Map<String, Organism> organisms = new LinkedHashMap<>();

    public String checkCondition(String organismName){
        StringBuilder sb = new StringBuilder();
        if (organisms.containsKey(organismName)) {
            sb.append(organisms.values().toString());
            int clustersSize = organisms.get(organismName).getClusters().size();
            if (clustersSize == 0){
                sb.append("--Cells: 0");
            }else {
                int cellsSize =0;
            }
        }
        return sb.toString();
    }
    public String createOrganism(String name) {

        String result = "";
        if (!organisms.containsKey(name)){
            Organism organism = new Organism(name);
            result = String.format("Created organism %s\n", name);
            organisms.put(name, organism);

        }else {
            result = String.format("Organism %s already exists", name);
        }
        return result;
    }
    public String addCluster(String organismName, String id, int rows, int cols){
        String result = "";
        if ((organisms.containsKey(organismName)) && (!organisms.get(organismName).getClusters().contains(id))){
            Cluster cluster = new Cluster(id, rows, cols);
            organisms.get(organismName).getClusters().add(cluster);
            result = String.format("Organism %s: Created cluster %s\n",
                    organismName, id);
        }
        return result;
    }
    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        String result = "";
        Cell cell = null;
        switch (cellType){
            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }
        if (organisms.containsKey(organismName) && organisms.get(organismName).getClusters().contains(clusterId)){ ;
            for (Organism organism : organisms.values()) {
                for (Cluster cluster : organism.getClusters()) {
                    if (cluster.getId().equals(clusterId)){
                        cluster.getCells().add(cell);
                        result = String.format("Organism <organism name>: Created cell <cell id> in cluster <cluster id",organismName,
                                cellId, clusterId);
                        break;
                    }
                }
            }
        }

        return result;
    }
    public String activateCluster(String organismName){
        return "";
    }

}
