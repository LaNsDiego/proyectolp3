package com.teamnab.demo.controller;

import com.teamnab.demo.model.Compra;
import com.teamnab.demo.model.CompraDetalle;
import com.teamnab.demo.model.Libro;
import com.teamnab.demo.model.Proveedor;
import com.teamnab.demo.service.CompraDetalleService;
import com.teamnab.demo.service.CompraService;
import com.teamnab.demo.service.LibroService;
import com.teamnab.demo.service.ProveedorService;
import com.teamnab.demo.utility.Calendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(CompraController.BASE_URL)
public class CompraController {
    public static final String BASE_URL = "/compra" ;

    @Autowired
    private ProveedorService daoProveedor;

    @Autowired
    private LibroService daoLibro;

    @Autowired
    private CompraService daoCompra;

    @Autowired
    private CompraDetalleService daoCompraDetalle;

    @GetMapping("/agregar")
    public String agregar(Model model){
        List<Proveedor> listadoProveedor = daoProveedor.findAll();
        List<Libro> listadoLibro = daoLibro.findAll();
        model.addAttribute("listadoProveedor",listadoProveedor);
        model.addAttribute("listadoLibro",listadoLibro);
        return "/view/bibliotecaria/compra/agregar";
    }

    @PostMapping("/agregar")
    public String agregar(
            Compra objCompra ,
            @RequestParam(value="listadoLibroId[]") int[] listadoLibroId,
            @RequestParam(value="listadoCantidad[]") int[] listadoCantidad,
            @RequestParam(value="listadoPrecio[]") double[] listadoPrecio,
            @RequestParam(value="listadoSubtotal[]") double[] listadoSubtotal
    ){

        objCompra.setFechaRegistro(Calendario.hoy());
        System.out.println(objCompra.getTotal());
        daoCompra.save(objCompra);
        if(objCompra.getId() > 0){
            for(int i = 0 ; i < listadoLibroId.length ; i++){
                CompraDetalle objNuevoDetalle = new CompraDetalle();
                objNuevoDetalle.setCompraId(objCompra.getId());
                objNuevoDetalle.setLibroId(listadoLibroId[i]);
                objNuevoDetalle.setCantidad(listadoCantidad[i]);
                objNuevoDetalle.setPrecio(listadoPrecio[i]);
                objNuevoDetalle.setSubtotal(listadoSubtotal[i]);
                daoCompraDetalle.save(objNuevoDetalle);
            }
        }

        return "redirect:/compra/listar";
    }

    @GetMapping("/detalle/{compraId}")
    public String listar(@PathVariable int compraId, Model model){
        model.addAttribute("listadoDetalle",daoCompraDetalle.findAllByCompraId(compraId));
        return "/view/bibliotecaria/compra/componente_detalle";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("listadoCompra",daoCompra.findAllByBibliotecaId(1));
        return "/view/bibliotecaria/compra/listar";
    }
}
