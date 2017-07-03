package com.cuandorindov2.main.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public class ApiValidator implements DefaultValidator {

    private final Validator validator;

    public ApiValidator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Override
    public <T> void validate(T beanToValidate) {
       final Set<ConstraintViolation<T>> constraintValidations = this.validator.validate(beanToValidate);
       if (!constraintValidations.isEmpty()) {
           //this may have more than one exception
           throw new ValidationException("At least, <<" + constraintValidations
                   .stream()
                   .findFirst()
                   .get()
                   .getMessage()
           + ">> is a failure in the validation.");
       }
    }
}
