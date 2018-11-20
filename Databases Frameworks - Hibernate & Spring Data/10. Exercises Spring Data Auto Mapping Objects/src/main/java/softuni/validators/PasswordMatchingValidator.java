package softuni.validators;

import org.springframework.stereotype.Component;
import softuni.models.binModels.user.RegisterUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {
    @Override
    public void initialize(PasswordMatching passwordMatching) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o instanceof RegisterUser){
            RegisterUser user = (RegisterUser)o;
            return user.getPassword().equals(user.getConfirmPassword());
        }
        return false;
    }


}
