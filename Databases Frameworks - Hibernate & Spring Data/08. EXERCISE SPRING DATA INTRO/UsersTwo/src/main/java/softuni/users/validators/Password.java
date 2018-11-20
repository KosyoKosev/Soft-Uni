package softuni.users.validators;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;

@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String massege() default "Invalid password format.";
    int minLength() default 6;
    int maxLength() default 30;
    boolean constraintDigit() default false;
    boolean constraintLowercase() default false;
    boolean contraintUppercase() default false;
    boolean constraintSpacialSymbols() default false;


    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
