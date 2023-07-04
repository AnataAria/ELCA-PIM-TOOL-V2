package com.anataarisa.pimtool.model.exception;

public class MandatoryIsEmptyException extends BaseException {
    public MandatoryIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
    public MandatoryIsEmptyException(String message){
        super(message);
    }
}
