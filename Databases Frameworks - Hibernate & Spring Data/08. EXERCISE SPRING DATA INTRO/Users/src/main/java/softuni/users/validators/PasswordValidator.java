package softuni.users.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String>{
}
