package exam.entities.organism;

import exam.entities.cluster.Cluster;

import java.util.*;

public class Organism {

    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(clusters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb
                    .append(String.format("Organism - %s", this.name))
                    .append(System.lineSeparator())
                    .append(String.format("--Clusters: %d", this.clusters.size()))
                    .append(System.lineSeparator());
        return sb.toString();
    }
}
