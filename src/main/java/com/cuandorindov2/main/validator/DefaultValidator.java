package com.cuandorindov2.main.validator;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public interface DefaultValidator {
   <E> void validate(E beanToValidate);
}
