package com.teamnab.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PrestamoController.BASE_URL)
public class PrestamoController {

    public static final String BASE_URL = "/prestamo";

    @GetMapping("/reservados")
    public String reservados(){
        return "/view/bibliotecaria/prestamo/reservados";
    }

    @GetMapping("/atendidos")
    public String atendidos(){
        return "/view/bibliotecaria/prestamo/atendidos";
    }
}
