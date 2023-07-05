package com.anataarisa.pimtool.model.exception;

import java.util.Set;

public class ProjectNumberAlreadyExistsException extends BaseException {


    public ProjectNumberAlreadyExistsException(String message){
        super(message);
    }
    public ProjectNumberAlreadyExistsException(String message, Set<String> errorMessages){
        super(message,errorMessages);
    }

}
