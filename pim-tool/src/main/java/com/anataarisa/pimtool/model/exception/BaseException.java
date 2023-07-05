package com.anataarisa.pimtool.model.exception;

import java.util.Set;

public class BaseException extends RuntimeException {
    private Set<String> errors;
    public BaseException(String message){
        super(message);
    }

    public BaseException(String message, Set<String> errors){
        super(message);
        this.errors = errors;
    }

    public Set<String> getErrors() {
        return errors;
    }

    public void setErrors(Set<String> errors) {
        this.errors = errors;
    }
}
