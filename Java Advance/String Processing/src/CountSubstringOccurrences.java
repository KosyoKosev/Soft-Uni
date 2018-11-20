import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();

        String pattern = reader.readLine().toLowerCase();

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println(count);
    }
}
