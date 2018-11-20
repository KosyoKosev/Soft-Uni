package softuni.util;

import softuni.models.binModels.user.RegisterUser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DataParser {

    public static <T> String getInvalidedParameterMessege(T target){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);
        for (ConstraintViolation<T> constrain : constraints) {
            return constrain.getMessage();
        }

        return null;
    }

    public static <T> Boolean checkIsValidate(T target){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);
        for (ConstraintViolation<T> constrain : constraints) {
            return false;
        }

        return true;
    }
}
