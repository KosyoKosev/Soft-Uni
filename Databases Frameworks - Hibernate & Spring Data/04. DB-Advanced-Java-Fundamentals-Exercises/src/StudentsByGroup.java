import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();

        while (true){
            String input = reader.readLine();

            if (input.equals("END")){
                break;
            }

            String[] split = input.split(" ");
            String firstName = split[0];
            String secondName = split[1];
            int group = Integer.parseInt(split[2]);

            if (group == 2) {
                students.put(firstName, secondName);
            }
        }

//        students.entrySet().stream()
//                .sorted((a,b) -> a.getKey().compareTo(b.getKey()))
//                .forEach(a -> System.out.println(a.getKey() + " " + a.getValue()));
    }
}
