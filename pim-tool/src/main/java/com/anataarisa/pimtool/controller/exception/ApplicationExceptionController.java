package com.anataarisa.pimtool.controller.exception;

import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import com.anataarisa.pimtool.model.exception.ErrorMessage;
import com.anataarisa.pimtool.model.exception.MandatoryIsEmptyException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApplicationExceptionController {
    @ExceptionHandler(EntitySearchNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> entityNotFoundException(EntitySearchNotFoundException entitySearchNotFoundException, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND, entitySearchNotFoundException.getMessage(),entitySearchNotFoundException.getCause().toString()), HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(MandatoryIsEmptyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> mandatoryIsEmptyException(MandatoryIsEmptyException mandatoryIsEmptyException, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND, mandatoryIsEmptyException.getMessage(),mandatoryIsEmptyException.getCause().toString()), HttpStatus.BAD_REQUEST);
    }

}
