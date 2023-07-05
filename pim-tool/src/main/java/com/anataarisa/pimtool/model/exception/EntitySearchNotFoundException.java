package com.anataarisa.pimtool.model.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;

public class EntitySearchNotFoundException extends BaseException {

    public EntitySearchNotFoundException(String message){
        super(message);
    }
    public EntitySearchNotFoundException(String message, Set<String> errorMessages){
        super(message,errorMessages);
    }
}
