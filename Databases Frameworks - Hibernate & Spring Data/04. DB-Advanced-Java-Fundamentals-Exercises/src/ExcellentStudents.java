import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("END")){
            String[] split = input.split(" ");

            String name = split[0] + " " + split[1];
            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < split.length; i++) {
                int grade = Integer.parseInt(split[i]);
                grades.add(grade);
            }

            students.put(name, grades);

            input = reader.readLine();
        }

        students.entrySet().stream()
                .filter(a -> a.getValue().contains(6))
                .forEach(a -> System.out.println(a.getKey()));
    }
}
