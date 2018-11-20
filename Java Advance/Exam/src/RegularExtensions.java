import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String command = reader.readLine();

        while (!"Print".equals(command)){


            Pattern pattern = Pattern.compile(command);

            command = reader.readLine();
        }
    }
}
