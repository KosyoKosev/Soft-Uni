package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputPersons = reader.readLine();
        String inputProducts = reader.readLine();

        String[] splitPersons = inputPersons.split(";");
        String[] splitProducts = inputProducts.split(";");

        List<ShoppingSpree.Person> persons = new ArrayList<>();
        List<ShoppingSpree.Product> products = new ArrayList<>();

        //HashMap<String, Double> persons = new HashMap<>();
       // HashMap<String, Double> products = new HashMap<>();

        for (int i = 0; i < splitPersons.length; i++) {
            String[] split = splitPersons[i].split("=");
            String name = split[0];
            double money = Double.parseDouble(split[1]);

            if (name.isEmpty()){
                System.out.println("Name cannot be an empty ");
                return;
            }
            if (money < 0){
                System.out.println("Money cannot be negative");
                return;
            }

            ShoppingSpree.Person person = new ShoppingSpree.Person(name, money);

            persons.add(person);
        }

        for (int i = 0; i < splitProducts.length; i++) {
            String[] split = splitProducts[i].split("=");
            String name = split[0];
            double cost = Double.parseDouble(split[1]);

            ShoppingSpree.Product product = new ShoppingSpree.Product(name, cost);

            products.add(product);
        }

        String command = reader.readLine();

        HashMap<String, List<String>> productList = new HashMap<>();


        while (!command.equals("END")){
            String[] split = command.split(" ");
            String namePerson = split[0];
            String nameProduct = split[1];

            for (ShoppingSpree.Person person : persons) {
                if (person.getName().equals(namePerson)){
                    for (ShoppingSpree.Product product : products) {
                        if (product.getName().equals(nameProduct)){
                            if (person.getMoney() >= product.getCost()){

                                if (!productList.containsKey(person.getName())){
                                    List<String> productName = new ArrayList<>();
                                    productName.add(product.getName());
                                    productList.put(person.getName(), productName);
                                }else {
                                    productList.get(person.getName()).add(product.getName());
                                }


                                System.out.printf("%s bought %s\n", person.getName(), product.getName());
                                person.setMoney(person.getMoney() - product.getCost());

                            }else {
                                System.out.printf("%s can't afford %s\n", person.getName(), product.getName());
                            }
                        }
                    }
                }
            }
            command = reader.readLine();
        }

        for (Map.Entry<String, List<String>> stringListEntry : productList.entrySet()) {
            for (ShoppingSpree.Person person : persons) {
                if (person.getName().equals(stringListEntry.getKey())){
                    person.setBagOfProducts(stringListEntry.getValue());
                }
            }
        }

        for (ShoppingSpree.Person person : persons) {
            if (person.getBagOfProducts() != null){
                List<String> productOfPerson = person.getBagOfProducts();
                System.out.printf("%s - ", person.getName());
                System.out.println(String.join(", ", productOfPerson));
            }else {
                System.out.printf("%s - Nothing bought", person.getName());
            }
        }
    }
}
