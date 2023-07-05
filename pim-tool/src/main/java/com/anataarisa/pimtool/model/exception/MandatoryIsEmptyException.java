package com.anataarisa.pimtool.model.exception;

import java.util.Set;

public class MandatoryIsEmptyException extends BaseException {

    public MandatoryIsEmptyException(String message){
        super(message);
    }

    public MandatoryIsEmptyException(String message, Set<String> errors) {
        super(message, errors);
    }

}
