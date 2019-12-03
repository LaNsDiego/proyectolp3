package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Kardex;
import com.biblioteca.biblioteca.model.KardexDetalle;
import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.service.KardexDetalleService;
import com.biblioteca.biblioteca.service.KardexService;
import com.biblioteca.biblioteca.service.PrestamoService;
import com.biblioteca.biblioteca.utility.Calendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(PrestamoController.BASE_URL)
public class PrestamoController {

    public static final String BASE_URL = "/prestamo";

    @Autowired
    HttpSession session ;

    @Autowired
    private PrestamoService daoPrestamo;

    @Autowired
    private KardexService daoKardex;
    @Autowired
    private KardexDetalleService daoKardexDetalle;

    @GetMapping("/reservados")
    public String reservados(Model model){
        model.addAttribute("listadoPrestamo",daoPrestamo.findAllByBibliotecaIdAndEstado(1,Prestamo.RESERVADO));
        return "/view/bibliotecaria/prestamo/reservados";
    }

    @GetMapping("/prestados")
    public String atendidos(Model model){
        model.addAttribute("listadoPrestamo",daoPrestamo.findAllByBibliotecaIdAndEstado(1,Prestamo.PRESTADO));
        return "/view/bibliotecaria/prestamo/prestados";
    }

    @GetMapping("/carrito")
    public String carrito(Model model){
        int usuarioId = Integer.valueOf(session.getAttribute("usuarioid").toString());
        List<Prestamo> listadoPrestamo = daoPrestamo.findAllByUsuarioIdAndEstado(usuarioId,Prestamo.RESERVADO);
        model.addAttribute("listadoPrestamo",listadoPrestamo);
        return "/view/estudiante/prestamo/carrito";
    }

    @GetMapping("/historial")
    public String historial(Model model){
        int usuarioId = Integer.valueOf(session.getAttribute("usuarioid").toString());
        List<Prestamo> listadoPrestamoAtendido = daoPrestamo.findAllByUsuarioIdAndEstado(usuarioId,Prestamo.PRESTADO);
        List<Prestamo> listadoPrestamoDevuelto = daoPrestamo.findAllByUsuarioIdAndEstado(usuarioId,Prestamo.DEVUELTO);
        model.addAttribute("listadoPrestamoAtendido",listadoPrestamoAtendido);
        model.addAttribute("listadoPrestamoDevuelto",listadoPrestamoDevuelto);
        return "/view/estudiante/prestamo/historial";
    }

    @PostMapping(value = "/reservar" , produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String reservar(Prestamo objPrestamo , HttpServletRequest request){
        HttpSession session = request.getSession();
        objPrestamo.setCantidad(1);
        objPrestamo.setEstado(Prestamo.RESERVADO);
        objPrestamo.setUsuarioId(Integer.valueOf(session.getAttribute("usuarioid").toString()));
        objPrestamo.setFechaCreacion(Calendario.hoy());
        daoPrestamo.save(objPrestamo);
        System.out.println(request.getParameter("bibliotecaId"));
        Kardex objKardex = daoKardex.getByBibliotecaIdAndLibroId(objPrestamo.getBibliotecaId(),objPrestamo.getLibroId());
        System.out.println(objPrestamo.getBibliotecaId() + " - " +objPrestamo.getLibroId());
        KardexDetalle objKardexDetalle = new KardexDetalle();

        objKardexDetalle.setCantidad(1);
        objKardexDetalle.setCostoTotal(objKardex.libro.getPrecio());
        objKardexDetalle.setCostoUnitario(objKardex.libro.getPrecio());
        objKardexDetalle.setTipoMovimientoId(2); // RESERVA LIBRO
        objKardexDetalle.setKardexId(objKardex.getId());
        daoKardexDetalle.save(objKardexDetalle);
        //ACTUALIZAR VALOR ECONOMICO DEL KARDEX
        objKardex.setTotal(objKardex.getTotal() - objKardex.libro.getPrecio());
        objKardex.setCantidad(objKardex.getCantidad() - 1);
        daoKardex.save(objKardex);
        return "{response : true}";
    }


    @PostMapping("/prestar")
    public @ResponseBody String prestar(Prestamo objPrestamo){

        objPrestamo = daoPrestamo.getOne(objPrestamo.getId());
        objPrestamo.setUsuarioBibliotecariaId(Integer.valueOf(session.getAttribute("usuarioid").toString()));
        objPrestamo.setEstado(Prestamo.PRESTADO);
        objPrestamo.setFechaAtencion(Calendario.hoy());
        daoPrestamo.save(objPrestamo);
        return "{response : true}";
    }

    @PostMapping("/devolver")
    public @ResponseBody String devolver(Prestamo objPrestamo){

        objPrestamo = daoPrestamo.getOne(objPrestamo.getId());
        objPrestamo.setUsuarioBibliotecariaId(Integer.valueOf(session.getAttribute("usuarioid").toString()));
        objPrestamo.setEstado(Prestamo.DEVUELTO);
        objPrestamo.setFechaDevolucion(Calendario.hoy());
        daoPrestamo.save(objPrestamo);

        Kardex objKardex = daoKardex.getByBibliotecaIdAndLibroId(objPrestamo.getBibliotecaId(), objPrestamo.getLibroId());
        objKardex.setCantidad(objKardex.getCantidad()+1);
        daoKardex.save(objKardex);

        KardexDetalle objKardexDetalle = new KardexDetalle();

        objKardexDetalle.setKardexId(objKardex.getId());
        objKardexDetalle.setTipoMovimientoId(3);
        objKardexDetalle.setCostoUnitario(objKardex.libro.getPrecio());
        objKardexDetalle.setCostoTotal(objKardex.libro.getPrecio());
        objKardexDetalle.setCantidad(1);
        daoKardexDetalle.save(objKardexDetalle);
        return "{response : true}";
    }
}
