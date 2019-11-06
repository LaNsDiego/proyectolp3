package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(BibliotecariaController.BASE_URL)

public class BibliotecariaController {
    public static final String BASE_URL = "/bibliotecaria";

    @GetMapping("/principal")
    public String principal(){
        return "/view/bibliotecaria/principal";
    }
}
