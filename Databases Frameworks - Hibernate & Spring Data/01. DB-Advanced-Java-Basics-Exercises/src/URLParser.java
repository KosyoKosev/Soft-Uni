import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLParser {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String protocol = "";
        String server = "";
        String resource = "";

        Pattern pattern1 = Pattern.compile("://");
        Matcher mach1 = pattern1.matcher(input);
        Pattern pattern2 = Pattern.compile("\\w\\/\\w");
        Matcher mach2 = pattern2.matcher(input);
        Pattern pattern3 = Pattern.compile("\\.");
        Matcher mach3 = pattern3.matcher(input);

        if (mach1.find()){
            String[] split = input.split("://");
            protocol = split[0];
            input = input.substring(protocol.length() + 3);
        }else {
            if (!mach2.find()){
                server = input;
            }
        }
        if (mach2.find()) {
            String[] split = input.split("/");
            server = split[0];
            input = input.substring(server.length() + 1);
            resource = input;
        }else {
            server = input;
        }



        System.out.printf("[protocol] = \"%s\"\n", protocol);
        System.out.printf("[server] = \"%s\"\n", server);
        System.out.printf("[resource] = \"%s\"\n", resource);
    }
}
