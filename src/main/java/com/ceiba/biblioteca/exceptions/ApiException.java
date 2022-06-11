package com.ceiba.biblioteca.exceptions;

public class ApiException {

    private String mensaje;

    public ApiException(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
