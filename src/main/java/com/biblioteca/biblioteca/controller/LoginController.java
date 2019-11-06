package com.biblioteca.biblioteca.controller;


import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(LoginController.BASE_URL)
public class LoginController {
    public static final String BASE_URL = "/";

    @GetMapping("")
    public String login(){
        return "/view/login";
    }

    @PostMapping("login")
    public String login(Usuario usuario){
        return "redirect:/bibliotecaria/principal";
    }
}
