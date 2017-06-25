package com.cuandorindov2.main.validator;

import com.cuandorindov2.main.resources.requests.StudentRequest;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public class ApiValidator implements DefaultValidator<StudentRequest>{

    private final Validator validator;

    @Autowired
    public ApiValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void Validate(StudentRequest beanToValidate) {
        Set<ConstraintViolation<?>> constraintValidations = this.validator.validate(beanToValidate, null);
    }
}
