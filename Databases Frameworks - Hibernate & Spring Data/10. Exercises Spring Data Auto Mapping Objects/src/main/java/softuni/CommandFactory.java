package softuni;

import softuni.commands.Executable;
import softuni.commands.RegisterCommand;
import softuni.services.GameService;
import softuni.services.UserService;

public class CommandFactory {

    private UserService userService;
    private GameService gameService;

    public CommandFactory(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public Executable getCommand(String command){
        switch (command){
            case "Register":
                return new RegisterCommand(this.userService, this.gameService);
        }

        return null;
    }
}
