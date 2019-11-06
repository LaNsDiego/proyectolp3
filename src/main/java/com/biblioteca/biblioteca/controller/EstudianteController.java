package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(EstudianteController.BASE_URL)
public class EstudianteController {
    public static final String BASE_URL = "/estudiante";

    @GetMapping("/principal")
    public String principal(){
        return "/view/estudiante/principal";
    }
}
