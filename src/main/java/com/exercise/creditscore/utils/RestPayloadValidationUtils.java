package com.exercise.creditscore.utils;


import javax.validation.*;
import java.util.Set;

public class RestPayloadValidationUtils {

    public static <T> void validate(T request) {
        ValidatorFactory factory  = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations =  validator.validate(request);
        if(violations != null && !violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
