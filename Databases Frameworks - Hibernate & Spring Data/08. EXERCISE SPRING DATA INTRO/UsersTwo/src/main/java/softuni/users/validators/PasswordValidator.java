package softuni.users.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int minLength;
    private int maxLength;
    private boolean constraintDigit;
    private boolean constraintLowercase;
    private boolean contraintUppercase;
    private boolean constraintSpacialSymbols;

    @Override
    public void initialize(Password password) {
        this.constraintDigit = password.constraintDigit();
        this.constraintLowercase = password.constraintLowercase();
        this.contraintUppercase = password.contraintUppercase();
        this.constraintSpacialSymbols = password.constraintSpacialSymbols();
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password.length() < this.minLength || password.length() > this.maxLength){
            return false;
        }

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher regex = pattern.matcher(password);
        if (!regex.find() && this.constraintLowercase){
            return false;
        }

        pattern = Pattern.compile("[A-Z]");
        regex = pattern.matcher(password);
        if (!regex.find() && this.contraintUppercase){
            return false;
        }

        pattern = Pattern.compile("[0-9]");
        regex = pattern.matcher(password);
        if (!regex.find() && this.constraintDigit){
            return false;
        }

        pattern = Pattern.compile("[!@#$%^&*()_+<>?]");
        regex = pattern.matcher(password);
        if (!regex.find() && this.constraintSpacialSymbols){
            return false;
        }
        return true;
    }
}
