package com.ceiba.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<ApiException> handleApiRequestException(ApiRequestException ex){

        ApiException apiException = new ApiException(ex.getMessage());
        apiException.setMensaje(ex.getMessage());

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
