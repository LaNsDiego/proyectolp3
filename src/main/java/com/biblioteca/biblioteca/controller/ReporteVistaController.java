package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ReporteController.BASE_URL)
public class ReporteVistaController {
    public static final String BASE_URL = "/reporte";

    @GetMapping("/vista")
    public String reportes(){
        return "view/bibliotecaria/reporte/decisiones";
    }
}
