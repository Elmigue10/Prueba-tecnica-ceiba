package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.entity.Prestamo;
import com.ceiba.biblioteca.exceptions.ApiRequestException;
import com.ceiba.biblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PrestamoService {

    private PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository){
        this.prestamoRepository = prestamoRepository;
    }

    public List<Prestamo> findAll(){
        return prestamoRepository.findAll();
    }

    public Prestamo findById(Integer id){
        return prestamoRepository.findById(id).get();
    }

    public void save(Prestamo prestamo) throws ParseException, ApiRequestException {
        String fecha = "";

        if(prestamo.getTipoUsuario() == 1){
            fecha = calculateDate(10);
        }

        if(prestamo.getTipoUsuario() == 2){
            fecha = calculateDate(8);
        }

        if(prestamo.getTipoUsuario() == 3){
            fecha = calculateDate(7);
        }

        prestamo.setFechaMaximaDevolucion(fecha);

        prestamoRepository.save(prestamo);
    }

    public void update(Prestamo prestamoReq){
        Prestamo prestamo = prestamoRepository.getOne(prestamoReq.getId());

        prestamo.setIsbn(prestamoReq.getIsbn());
        prestamo.setIdentificacionUsuario(prestamoReq.getIdentificacionUsuario());
        prestamo.setTipoUsuario(prestamoReq.getTipoUsuario());

        prestamoRepository.save(prestamo);
    }

    public List<Prestamo> findPrestamosByIdenficacion(String identificaion){
        return prestamoRepository.findPrestamoByIdentificacionUsuario(identificaion);
    }

    public String calculateDate(int cantidadDias) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int diasAgregados = 0;
        while(diasAgregados < cantidadDias){
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if(!(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                    calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)){
                ++diasAgregados;
            }
        }

        date = calendar.getTime();
        return dateFormat.format(date);
    }

}
