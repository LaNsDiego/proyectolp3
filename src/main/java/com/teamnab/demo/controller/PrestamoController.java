package com.teamnab.demo.controller;

import com.teamnab.demo.model.Prestamo;
import com.teamnab.demo.service.PrestamoService;
import com.teamnab.demo.utility.Calendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
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
    public String carrito(Model model){
        List<Prestamo> listadoPrestamo = daoPrestamo.findAllByUsuarioIdAndEstado(1,Prestamo.RESERVADO);
        model.addAttribute("listadoPrestamo",listadoPrestamo);
        return "/view/estudiante/prestamo/carrito";
    }

    @GetMapping("/historial")
    public String historial(Model model){
        List<Prestamo> listadoPrestamoAtendido = daoPrestamo.findAllByUsuarioIdAndEstado(1,Prestamo.ATENDIDO);
        List<Prestamo> listadoPrestamoDevuelto = daoPrestamo.findAllByUsuarioIdAndEstado(1,Prestamo.DEVUELTO);
        model.addAttribute("listadoPrestamoAtendido",listadoPrestamoAtendido);
        model.addAttribute("listadoPrestamoDevuelto",listadoPrestamoDevuelto);
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
