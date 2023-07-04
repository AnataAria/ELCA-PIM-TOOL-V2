package com.anataarisa.pimtool.model.exception;

public class BaseException extends RuntimeException{
    private String message;
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message){
        super(message);
    }

    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
