import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> matchs = new LinkedHashMap<>();
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(?<firstChar>[,_])[a-zA-Z]+(?<digit>[\\d])");

        String result = "";
        while (!input.equals("Ascend")){
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                String match = matcher.group();
                String matchForDecrypt = match.substring(1, match.length() - 1);

                String firstChar = matcher.group("firstChar");
                int digit = Integer.parseInt(matcher.group("digit"));
                StringBuilder decryptValue = new StringBuilder();

                if (firstChar.equals("_")){
                    for (char ch : matchForDecrypt.toCharArray()) {
                        char resultFromDecryptChar = (char) (ch - digit);
                        decryptValue.append(resultFromDecryptChar);
                    }
                }else {
                    for (char ch : matchForDecrypt.toCharArray()) {
                        char resultFromDecryptChar = (char) (ch + digit);
                        decryptValue.append(resultFromDecryptChar);
                    }
                }
                matchs.putIfAbsent(match, decryptValue.toString());
                input = input.replaceAll(match, decryptValue.toString());
            }
            System.out.println(input);

            input = reader.readLine();
            input = decryptInput(input, matchs);
        }
    }

    private static String decryptInput(String input, Map<String, String> matchs) {
        for (Map.Entry<String, String> stringStringEntry : matchs.entrySet()) {
            input = input.replaceAll(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        return input;
    }
}
