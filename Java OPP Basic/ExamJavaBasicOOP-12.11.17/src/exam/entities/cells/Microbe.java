package exam.entities.cells;

public abstract class Microbe extends Cell{

    private int virulence;

    Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.virulence);
        return sb.toString();
    }
}

