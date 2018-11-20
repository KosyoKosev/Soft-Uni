package exam.entities.cluster;

import exam.entities.cells.Cell;
import exam.entities.organism.Organism;

import java.util.*;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        List<String> clustersName = new ArrayList<>();
        if (!clustersName.contains(id)){
            this.id = id;
            clustersName.add(id);
        }
        this.rows = rows;
        this.cols = cols;
        this.cells = new LinkedList<>();
    }

    public String getId() {
        return id;
    }


        public List<Cell> getCells() {

        return Collections.unmodifiableList(cells);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s--Cells: %d", Organism.class.toString(), this.getCells().size()));
        return sb.toString();
    }
}
