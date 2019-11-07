package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(BibliotecariaController.BASE_URL)


public class BibliotecariaController {
    public static final String BASE_URL = "/bibliotecaria";
    @Autowired
    HttpSession session ;

    @GetMapping("/principal")
    public String principal(){
        System.out.println(session.getAttribute("nombre"));
        System.out.println(session.getAttribute("correo"));
        return "/view/bibliotecaria/principal";
    }
}
