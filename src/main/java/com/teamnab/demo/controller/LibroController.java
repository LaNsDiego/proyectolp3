package com.teamnab.demo.controller;

import com.teamnab.demo.model.*;
import com.teamnab.demo.service.*;
import com.teamnab.demo.utility.Calendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(LibroController.BASE_URL)
public class LibroController {
    public static final String BASE_URL = "/libro";

    @Autowired
    private CategoiaService daoCategoria;
    @Autowired
    private MateriaService daoMateria;
    @Autowired
    private LibroService daoLibro;
    @Autowired
    private LibroAutorService daoLibroAutor;
    @Autowired
    private LibroMateriaService daoLibroMateria;
    @Autowired
    private AutorService daoAutor;

    @GetMapping("/agregar")
    public String agrear(Model model){
        List<Categoria> listadoCategoria = daoCategoria.findAll();
        List<Autor> listadoAutor = daoAutor.findAll();
        List<Materia> listadoMateria = daoMateria.findAll();
        model.addAttribute("listadoCategoria",listadoCategoria);
        model.addAttribute("listadoAutor",listadoAutor);
        model.addAttribute("listadoMateria",listadoMateria);
        return "/view/bibliotecaria/libro/agregar";
    }

    @PostMapping("/agregar")
    public String agrear(Libro objLibro , @RequestParam(value="autores[]") int[] autores ,@RequestParam(value="materias[]") int[] materias){
        objLibro.setFechaCreacion(Calendario.hoy());
        daoLibro.save(objLibro);
        for ( int i = 0 ; i < autores.length ; i++){
            LibroAutor objLibroAutor = new LibroAutor();
            objLibroAutor.setAutorId(autores[i]);
            objLibroAutor.setLibroId(objLibro.getId());
            daoLibroAutor.save(objLibroAutor);
        }
        for ( int i = 0 ; i < materias.length ; i++){
            LibroMateria objLibroMateria = new LibroMateria();
            objLibroMateria.setMateriaId(materias[i]);
            objLibroMateria.setLibroId(objLibro.getId());
            daoLibroMateria.save(objLibroMateria);
        }

        return "redirect:/libro/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("listadoLibro", daoLibro.findAll());
        return "/view/bibliotecaria/libro/listar";
    }
}
