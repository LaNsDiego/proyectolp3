package com.teamnab.demo.controller;

import com.teamnab.demo.model.Proveedor;
import com.teamnab.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(CompraController.BASE_URL)
public class CompraController {
    public static final String BASE_URL = "/compra" ;

    @Autowired
    private ProveedorService daoProveedor;

    @GetMapping("/agregar")
    public String agregar(Model model){
        List<Proveedor> listadoProveedor = daoProveedor.findAll();
        model.addAttribute("listadoProveedor",listadoProveedor);
        return "/view/bibliotecaria/compra/agregar";
    }

    @GetMapping("/listar")
    public String listar(){
        return "/view/bibliotecaria/compra/listar";
    }
}
