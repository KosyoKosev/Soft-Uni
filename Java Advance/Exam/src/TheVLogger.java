import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TheVLogger {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<Integer, Integer>> vloggers = new HashMap<>();
        String input = reader.readLine();

        while (!"Statistics".equals(input)){

            String[] split = input.split("\\s+");
            String vloggerName = split[0];
            String command = split[1];

            if (command.equals("joined")){
                if (!vloggers.containsKey(vloggerName)){
                    vloggers.put(vloggerName, new HashMap<Integer, Integer>());
                }
                vloggers.get(vloggerName).put(0,0);
            }else {
                String followerName = split[2];

                if ((vloggers.containsKey(vloggerName)) && (!vloggerName.equals(followerName)) && (vloggers.containsKey(followerName))){

                    vloggers.get(followerName).keySet();
                    vloggers.get(vloggerName).keySet();
                }
            }


            input = reader.readLine();
        }
        System.out.println();
    }
}
