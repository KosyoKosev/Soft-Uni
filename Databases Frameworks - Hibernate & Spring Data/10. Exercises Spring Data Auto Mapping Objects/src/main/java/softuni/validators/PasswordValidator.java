package softuni.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password password) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher regex = pattern.matcher(password);
        if (!regex.find()) {
            return false;
        }

        Pattern patternTwo = Pattern.compile("[A-Z]");
        regex = patternTwo.matcher(password);
        if (!regex.find()){
            return false;
        }

        Pattern patternThree = Pattern.compile("[0-9]");
        regex = patternThree.matcher(password);
        if (!regex.find()){
            return false;
        }

        return true;
    }
}
