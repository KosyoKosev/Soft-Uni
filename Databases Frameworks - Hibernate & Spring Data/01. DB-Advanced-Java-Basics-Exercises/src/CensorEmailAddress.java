import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CensorEmailAddress {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String text = reader.readLine();
        int indexA = input.indexOf("@");

        String domain = input.substring(indexA);
        int lengthUserName = indexA;
        String userName = String.format("%"+ lengthUserName + "s", "").replace(' ', '*');

        String replacementEmail = userName + domain;

        String result = text.replace(input, replacementEmail);

        System.out.println(result);
    }
}
