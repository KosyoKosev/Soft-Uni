package entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "towns")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Town {

    @NotNull
    @Id
    @Column(name = "town_id")
    private int id;

    @NotNull
    @Column(name = "town_name")
    private String name;

    @NotNull
    @Column(name = "count_population")
    private int population;

    @NotNull
    @Column(name = "branch_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    private int branchId;

    public Town() {
    }

    public Town(int id, String name, int population, int branchId) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.branchId = branchId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
