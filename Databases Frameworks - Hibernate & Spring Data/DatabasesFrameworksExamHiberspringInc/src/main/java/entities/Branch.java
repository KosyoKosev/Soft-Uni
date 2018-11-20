package entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "branchs")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Branch {

    @NotNull
    @Id
    @Column(name = "branch_id")
    private int id;

    @NotNull
    @Column(name = "branch_name")
    private String name;

    @NotNull
    @Column(name = "employee_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private int employeeId;

    @NotNull
    @Column(name = "product_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "productid")
    private int productId;

    public Branch() {
    }

    public Branch(int id, String name, int employeeId, int productId) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.productId = productId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
