package com.ceiba.biblioteca.controller;


import com.ceiba.biblioteca.entity.Prestamo;
import com.ceiba.biblioteca.entity.PrestamoDTO;
import com.ceiba.biblioteca.exceptions.ApiRequestException;
import com.ceiba.biblioteca.service.PrestamoService;
import com.ceiba.biblioteca.util.TipoUsuarioEnum;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {

    private PrestamoService prestamoService;
    TipoUsuarioEnum[] tiposUsuario = TipoUsuarioEnum.values();
    PrestamoDTO prestamoDTO = new PrestamoDTO();

    public PrestamoControlador(PrestamoService prestamoService){
        this.prestamoService = prestamoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Prestamo>> getAll(){
        return new ResponseEntity<>(prestamoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> findById(@PathVariable Integer id){
        return new ResponseEntity<>(prestamoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PrestamoDTO> save(@RequestBody Prestamo prestamo) throws ParseException, ApiRequestException {

        List<Prestamo> prestamos = prestamoService.findPrestamosByIdenficacion(prestamo.getIdentificacionUsuario());

        if (!Arrays.stream(tiposUsuario).map(TipoUsuarioEnum::getCode)
                .filter(prestamo.getTipoUsuario()::equals).findFirst().isPresent()){
            throw new ApiRequestException("Tipo de usuario no permitido en la biblioteca");
        }

        if(prestamos.size() >= 1 && prestamo.getTipoUsuario()==3){
            throw new ApiRequestException("El usuario con identificación " +
                    prestamo.getIdentificacionUsuario() +
                    " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo");
        }

        prestamoService.save(prestamo);

        prestamoDTO.setId(prestamo.getId());
        prestamoDTO.setFechaMaximaDevolucion(prestamo.getFechaMaximaDevolucion());

        return new ResponseEntity<>(prestamoDTO, HttpStatus.OK);
    }

}

