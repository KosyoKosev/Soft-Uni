import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Highscore {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        Map<String, Long> playerScore = new LinkedHashMap<>();
        Map<String, List<String>> playerFight = new LinkedHashMap<>();

        while (!command.equals("osu!")){
            String[] splitScore = command.split(" ");
            String[] splitName = splitScore[1].split("<->");
            long scorePlayer1 = Long.valueOf(splitScore[0]);
            long scorePlayer2 = Long.valueOf(splitScore[2]);
            String namePlayer1 = splitName[0];
            String namePlayer2 = splitName[1];

            fillMaps(namePlayer1, namePlayer2, playerScore, playerFight, scorePlayer1, scorePlayer2);
            fillMaps(namePlayer2, namePlayer1, playerScore, playerFight, scorePlayer2, scorePlayer1);

            command = reader.readLine();
        }
        StringBuilder result = new StringBuilder();
        playerScore.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(),a.getValue())).forEach(v -> {
            result.append(v.getKey()).append(" - (").append(v.getValue()).append(")").append("\n");
            playerFight.get(v.getKey()).forEach(s -> result.append(s).append("\n"));
        });
        System.out.println(result);
    }

    private static void fillMaps(String namePlayer1, String namePlayer2, Map<String, Long> playerScore, Map<String, List<String>> playerFight, long scorePlayer1, long scorePlayer2) {
        if (!playerScore.containsKey(namePlayer1)){
            playerScore.put(namePlayer1, 0L);
        }
        playerScore.put(namePlayer1, playerScore.get(namePlayer1) + (scorePlayer1 - scorePlayer2));

        if (!playerFight.containsKey(namePlayer1)){
            playerFight.put(namePlayer1, new LinkedList<>());
        }
        playerFight.get(namePlayer1).add(String.format("*   %s <-> %d", namePlayer2, scorePlayer1 - scorePlayer2));
    }
}
