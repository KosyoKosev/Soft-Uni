import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();

        while (true){
            String input = reader.readLine();

            if (input.equals("END")){
                break;
            }

            String[] split = input.split(" ");

            String name = split[0] + " " + split[1];
            String email = split[2];

            students.put(name, email);
        }

        students.entrySet().stream()
                .filter(a -> a.getValue().endsWith("@gmail.com"))
                .forEach(a -> System.out.println(a.getKey()));
    }
}
