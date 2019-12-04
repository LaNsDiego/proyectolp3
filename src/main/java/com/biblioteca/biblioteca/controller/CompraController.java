package com.biblioteca.biblioteca.controller;


import com.biblioteca.biblioteca.model.*;
import com.biblioteca.biblioteca.service.*;
import com.biblioteca.biblioteca.utility.Calendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private KardexService daoKardex;

    @Autowired
    private KardexDetalleService daoKardexDetalle;

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
                Kardex objKardex = daoKardex.getByBibliotecaIdAndLibroId(objCompra.getBibliotecaId(),objNuevoDetalle.getLibroId());
                if( objKardex == null){
                    objKardex = new Kardex();
                    objKardex.setBibliotecaId(objCompra.getBibliotecaId());
                    objKardex.setLibroId(objNuevoDetalle.getLibroId());
                    objKardex.setRazonSocial("Biblioteca UPT");
                    objKardex.setRuc("10987654217");
                    objKardex.setCantidad(0);
                    objKardex.setTotal(0);
                    daoKardex.save(objKardex);
                }

                KardexDetalle objKardexDetalle = new KardexDetalle();
                objKardexDetalle.setKardexId(objKardex.getId());
                objKardexDetalle.setCantidad(objNuevoDetalle.getCantidad());
                objKardexDetalle.setCostoUnitario(objNuevoDetalle.getPrecio());
                objKardexDetalle.setTipoMovimientoId(1);
                objKardexDetalle.setCostoTotal(objNuevoDetalle.getSubtotal());
                daoKardexDetalle.save(objKardexDetalle);

                Kardex actualKardex = daoKardex.getOne(objKardexDetalle.getKardexId());
                actualKardex.setCantidad(actualKardex.getCantidad() + objKardexDetalle.getCantidad());
                actualKardex.setTotal(objKardexDetalle.getCostoTotal());
                daoKardex.save(actualKardex);

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
    public String listar(Model model, HttpServletRequest request){
        int bibliotecaId = Integer.valueOf(request.getSession().getAttribute("bibliotecaid").toString());
        model.addAttribute("listadoCompra",daoCompra.findAllByBibliotecaId(bibliotecaId));
        return "/view/bibliotecaria/compra/listar";
    }
}
