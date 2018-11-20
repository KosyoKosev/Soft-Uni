package ShoppingSpree;

import java.util.List;

public class Person {
    private String name;
    private  double money;
    private List<String> bagOfProducts;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Person(String name, double money, List<String> bagOfProducts) {
        this.name = name;
        this.money = money;
        this.bagOfProducts = bagOfProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<String> getBagOfProducts() {
        return bagOfProducts;
    }

    public void setBagOfProducts(List<String> bagOfProducts) {
        this.bagOfProducts = bagOfProducts;
    }
}
