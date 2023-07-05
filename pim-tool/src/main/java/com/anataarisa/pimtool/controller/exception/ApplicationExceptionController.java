package com.anataarisa.pimtool.controller.exception;

import com.anataarisa.pimtool.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class ApplicationExceptionController {
    @ExceptionHandler(EntitySearchNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> entityNotFoundException(EntitySearchNotFoundException entitySearchNotFoundException) {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND, entitySearchNotFoundException.getMessage(), new ArrayList<>(entitySearchNotFoundException.getErrors())), HttpStatus.NOT_FOUND) ;
    }

    @ExceptionHandler(MandatoryIsEmptyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> mandatoryIsEmptyException(MandatoryIsEmptyException mandatoryIsEmptyException) {
        ErrorMessage em =new ErrorMessage(HttpStatus.BAD_REQUEST, mandatoryIsEmptyException.getMessage(),new ArrayList<>(mandatoryIsEmptyException.getErrors()));
        return new ResponseEntity<>(em, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PermissionNotAllowException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<?> permissionNotAllowException(PermissionNotAllowException permissionNotAllowException) {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_ACCEPTABLE, permissionNotAllowException.getMessage(), new ArrayList<>(permissionNotAllowException.getErrors())), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ProjectNumberAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> projectNumberAlreadyExistException(ProjectNumberAlreadyExistsException projectNumberAlreadyExistsException){
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST, projectNumberAlreadyExistsException.getMessage(),new ArrayList<>(projectNumberAlreadyExistsException.getErrors())), HttpStatus.BAD_REQUEST);
    }
}
