package com.teamnab.demo.controller;

import com.teamnab.demo.model.Kardex;
import com.teamnab.demo.service.KardexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KardexController {

    private static final String BASE_URL = "/kardex";

    @Autowired
    private KardexService daoKardex;

    @GetMapping("/catalogo")
    public String listar(Model model){
        model.addAttribute("listadoKardex", daoKardex.findAll());
        return "/view/estudiante/catalogo/listar";
    }
}
