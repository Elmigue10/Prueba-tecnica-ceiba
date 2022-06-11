package com.ceiba.biblioteca.util;

public enum TipoUsuarioEnum {

    AFILIADO(1, "Usuario afiliado"),
    EMPLEADO(2, "Usuario empleado de la biblioteca"),
    INVITADO(3, "Usuario invitado");

    private final Integer code;
    private final String description;

    TipoUsuarioEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
