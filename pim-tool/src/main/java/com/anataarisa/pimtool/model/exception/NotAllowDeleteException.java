package com.anataarisa.pimtool.model.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class NotAllowDeleteException extends BaseException {

    public NotAllowDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllowDeleteException(String message){
        super(message);
    }
}
