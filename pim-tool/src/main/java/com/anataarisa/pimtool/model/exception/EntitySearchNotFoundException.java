package com.anataarisa.pimtool.model.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class EntitySearchNotFoundException extends BaseException {
    public EntitySearchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EntitySearchNotFoundException(String message){
        super(message);
    }
}
