package com.ceiba.biblioteca.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Integer id;

    private String isbn;

    private String identificacionUsuario;

    private Integer tipoUsuario;

    private String fechaMaximaDevolucion;

    public Integer getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", identificacionUsuario='" + identificacionUsuario + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", fechaDevolucion='" + fechaMaximaDevolucion + '\'' +
                '}';
    }
}
