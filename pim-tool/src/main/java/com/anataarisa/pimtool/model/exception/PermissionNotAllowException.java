package com.anataarisa.pimtool.model.exception;

import java.util.Set;

public class PermissionNotAllowException extends BaseException {
    public PermissionNotAllowException(String message){
        super(message);
    }
    public PermissionNotAllowException(String message, Set<String> details){
        super(message, details);
    }
}
