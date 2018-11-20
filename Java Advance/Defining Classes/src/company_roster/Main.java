package company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, List<Employee>> departments = new HashMap<>();

        Employee employee = null;
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");

            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            switch (line.length){
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (line[4].matches("\\d+")){
                        int age = Integer.parseInt(line[4]);
                        employee = new Employee(name, salary, position, department, age);
                    }else {
                        String email = line[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = line[4];
                    int age = Integer.parseInt(line[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }

            if (!departments.containsKey(department)){
                departments.put(department, new ArrayList<>());
            }
            departments.get(department).add(employee);
        }

        departments.entrySet().stream().sorted((d1, d2) ->
                Double.compare(d2.getValue().stream().mapToDouble(Employee:: getSalary).average().getAsDouble(),
                d1.getValue().stream().mapToDouble(Employee:: getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder sb = new StringBuilder(String.format("Highest Average Salary: %s%n", d.getKey()));
                    d.getValue().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .forEach(e -> sb.append(e).append(System.lineSeparator()));

                    System.out.println(sb.toString());
                });
    }
}
