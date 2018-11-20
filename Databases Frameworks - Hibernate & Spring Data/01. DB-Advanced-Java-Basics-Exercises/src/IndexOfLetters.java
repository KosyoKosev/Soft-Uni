import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IndexOfLetters {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Map<Character, Integer>> characterIndex = new LinkedList<>();

        char[] input = reader.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            char character = input[i];
            int index = character - 97;

            map.put(character, index);
            characterIndex.add(map);
        }

        for (Map<Character, Integer> character : characterIndex)
            for (Map.Entry<Character, Integer> characterIntegerEntry : character.entrySet()) {
                System.out.println(characterIntegerEntry.getKey() + " -> " + characterIntegerEntry.getValue());
            }
    }
}
