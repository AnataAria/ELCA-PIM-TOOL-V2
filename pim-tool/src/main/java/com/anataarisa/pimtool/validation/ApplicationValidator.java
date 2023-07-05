package com.anataarisa.pimtool.validation;

import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ApplicationValidator<T> {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    public Set<String> validate(T validateObject){
        Set<ConstraintViolation<T>>violations = validator.validate(validateObject);
        if(!violations.isEmpty()){
            return violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

}
