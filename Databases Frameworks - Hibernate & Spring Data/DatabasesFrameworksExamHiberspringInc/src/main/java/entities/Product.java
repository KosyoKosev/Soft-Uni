package entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {

    @NotNull
    @Id
    @Column(name = "product_id")
    private int id;

    @NotNull
    @Column(name = "product_name")
    private String name;

    @NotNull
    @Column(name = "count_clients")
    private int clients;

    public Product() {
    }

    public Product(int id, String name, int clients) {
        this.id = id;
        this.name = name;
        this.clients = clients;
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

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }
}
