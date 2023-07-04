package com.anataarisa.pimtool.model.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ProjectNumberAlreadyExistsException extends BaseException {
    public ProjectNumberAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNumberAlreadyExistsException(String message){
        super(message);
    }
}
