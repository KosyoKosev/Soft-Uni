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
        Map<String, Long> playerScores = new LinkedHashMap<>();
        Map<String, List<String>> playerDuels = new LinkedHashMap<>();

        while (true) {
            String[] input = reader.readLine().split(" ");

            if ("osu!".equals(input[0])) {
                break;
            }
            String[] splitInput = input[1].split("<->");
            String namePlayerOne = splitInput[0];
            String namePlayerTwo = splitInput[1];
            long scorePlayerOne = Long.parseLong(input[0]);
            long scorePlayerTwo = Long.parseLong(input[2]);
            playerScores.putIfAbsent(namePlayerOne, 0L);
            playerScores.put(namePlayerOne, (playerScores.get(namePlayerOne) + (scorePlayerOne - scorePlayerTwo)));
            playerScores.putIfAbsent(namePlayerTwo, 0L);
            playerScores.put(namePlayerTwo, (playerScores.get(namePlayerTwo) + (scorePlayerTwo - scorePlayerOne)));

            playerDuels.putIfAbsent(namePlayerOne, new LinkedList<>());
            playerDuels.get(namePlayerOne).add(String.format("*   %s <-> %d", namePlayerTwo, (scorePlayerOne - scorePlayerTwo)));
            playerDuels.putIfAbsent(namePlayerTwo, new LinkedList<>());
            playerDuels.get(namePlayerTwo).add(String.format("*   %s <-> %d", namePlayerOne, (scorePlayerTwo - scorePlayerOne)));
        }
        StringBuilder result = new StringBuilder();
        playerScores.entrySet().stream().sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(v ->{
                    result.append(v.getKey()).append(" - (").append(v.getValue()).append(")\n");
                    playerDuels.get(v.getKey()).forEach(s -> result.append(s).append("\n"));
                });
        System.out.println(result.toString());
    }
}
