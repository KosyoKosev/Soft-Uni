package softuni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.CommandFactory;
import softuni.commands.Executable;
import softuni.services.GameService;
import softuni.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
public class Terminal implements CommandLineRunner {

    private final UserService userService;

    private final GameService gameService;

    @Autowired
    public Terminal(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... strings) throws Exception {

        CommandFactory commandFactory = new CommandFactory(this.userService,this.gameService);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = reader.readLine();

            if (input.equals("END")){
                break;
            }

            String[] split = input.split("\\|");

            String command = split[0];

            String[] newParams = new String[split.length - 1];

            if (split.length > 1){
                newParams = Arrays.copyOfRange(split,1,split.length);
            }

            Executable executable = commandFactory.getCommand(command);
            String result = executable.execute(newParams);
            System.out.println(result);
        }

    }
}
