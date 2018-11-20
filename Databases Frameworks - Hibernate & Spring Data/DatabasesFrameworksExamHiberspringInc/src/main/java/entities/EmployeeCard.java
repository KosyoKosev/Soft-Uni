package entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "employee_cards")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EmployeeCard {

    @NotNull
    @Id
    @Column(name = "employee_card_id")
    private int id;

    @NotNull
    @Column(name = "card_number", unique = true)
    private  String number;

    @NotNull
    @Column(name = "employee_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private int employeeId;

    public EmployeeCard() {
    }

    public EmployeeCard(int id, String number, int employeeId) {
        this.id = id;
        this.number = number;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
