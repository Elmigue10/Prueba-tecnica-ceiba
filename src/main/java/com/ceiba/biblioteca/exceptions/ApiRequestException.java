package com.ceiba.biblioteca.exceptions;

public class ApiRequestException extends RuntimeException{

    private String mensaje;

    public ApiRequestException(String mensaje){
        super(mensaje);
    }

}
