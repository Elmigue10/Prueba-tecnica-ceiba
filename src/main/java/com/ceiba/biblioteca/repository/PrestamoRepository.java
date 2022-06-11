package com.ceiba.biblioteca.repository;

import com.ceiba.biblioteca.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    public List<Prestamo> findPrestamoByIdentificacionUsuario(String identificacion);

}
