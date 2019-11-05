package com.teamnab.demo.controller;

import com.teamnab.demo.model.Prestamo;
import com.teamnab.demo.service.PrestamoService;
import com.teamnab.demo.utility.Calendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Properties;

@Controller
@RequestMapping(PrestamoController.BASE_URL)
public class PrestamoController {

    public static final String BASE_URL = "/prestamo";

    @Autowired
    private PrestamoService daoPrestamo;

    @GetMapping("/reservados")
    public String reservados(){
        return "/view/bibliotecaria/prestamo/reservados";
    }

    @GetMapping("/atendidos")
    public String atendidos(){
        return "/view/bibliotecaria/prestamo/atendidos";
    }

    @GetMapping("/carrito")
    public String carrito(){
        return "/view/estudiante/prestamo/carrito";
    }

    @PostMapping("/agregar")
    public boolean agregar(Prestamo objPrestamo){
        objPrestamo.setCantidad(1);
        objPrestamo.setEstado("RESERVADO");
//        objPrestamo.setFechaDevolucion(Calendario.aumentarDias(new Date(),3));
        objPrestamo.setFechaCreacion(Calendario.hoy());
        daoPrestamo.save(objPrestamo);
        return objPrestamo.getId() > 0;
    }
}
