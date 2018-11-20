package softuni.commands;

import softuni.models.binModels.user.RegisterUser;
import softuni.services.GameService;
import softuni.services.UserService;
import softuni.util.DataParser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RegisterCommand extends Command {
    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        RegisterUser registerUser = new RegisterUser();

        try{
            registerUser.setEmail(params[0]);
            registerUser.setPassword(params[1]);
            registerUser.setConfirmPassword(params[2]);
            registerUser.setFullName(params[3]);

            if (!DataParser.checkIsValidate(registerUser)){
                return DataParser.getInvalidedParameterMessege(registerUser);
            }
            super.getUserService().persist(registerUser);
        }catch (Exception e){
            return e.getMessage();
        }
        return String.format("%s was registered", params[3]);
    }
}
