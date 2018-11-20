import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        Pattern pattern = Pattern.compile("(?<firstChar>[,_])(?<mach>[a-zA-Z]+)(?<digit>[0-9])");
        HashMap<String,String>  map = new LinkedHashMap<>();

        while (!command.equals("Ascend")){
            command = decryptCommandWithOldValues(command,map);
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()){
                String match = matcher.group();
                String firstChar = matcher.group("firstChar");
                int digit = Integer.valueOf(matcher.group("digit"));
                String messege = matcher.group("mach");
                StringBuilder builder = new StringBuilder();
                if (firstChar.equals(",")){
                    for (int i = 0; i < messege.length(); i++) {
                        builder.append((char)(messege.charAt(i) + digit));
                    }
                }else {
                    for (int i = 0; i < messege.length(); i++) {
                        builder.append((char)(messege.charAt(i) - digit));
                    }
                }
                map.put(match,builder.toString());
                command = command.replace(match, builder.toString());
            }
            System.out.println(command);

            command = reader.readLine();
        }

    }

    private static String decryptCommandWithOldValues(String command, HashMap<String, String> map) {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            command = command.replaceAll(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        return command;
    }
}
