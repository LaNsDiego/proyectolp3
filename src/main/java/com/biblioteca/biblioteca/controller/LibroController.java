package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.*;
import com.biblioteca.biblioteca.service.*;
import com.biblioteca.biblioteca.utility.Calendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


@Controller
@RequestMapping(LibroController.BASE_URL)
public class LibroController {


    public static final String BASE_URL = "/libro";
    private final String DIRECTORIO_IMAGENES = System.getProperty("user.dir")+"/src/main/resources/static/imagenes/";
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
    public String agregar(Model model){
        List<Categoria> listadoCategoria = daoCategoria.findAll();
        List<Autor> listadoAutor = daoAutor.findAll();
        List<Materia> listadoMateria = daoMateria.findAll();
        model.addAttribute("listadoCategoria",listadoCategoria);
        model.addAttribute("listadoAutor",listadoAutor);
        model.addAttribute("listadoMateria",listadoMateria);
        return "/view/bibliotecaria/libro/agregar";
    }

    @PostMapping("/agregar")
    public String agregar(Libro objLibro ,
                         @RequestParam(value="autores[]") int[] autores ,
                         @RequestParam(value="materias[]") int[] materias ,
                         @RequestParam("imagen") MultipartFile imagen ){
        objLibro.setFechaCreacion(Calendario.hoy());
        if(!imagen.isEmpty()){
            objLibro.setPortada(new Date().getTime() + imagen.getOriginalFilename());
            System.out.println(imagen.getOriginalFilename() + new Date().getTime());
        }
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


        if(!imagen.isEmpty()) {
          Path ruta =Paths.get(DIRECTORIO_IMAGENES+objLibro.getPortada());
          System.out.println(ruta);
            try{
                Files.write(ruta, imagen.getBytes());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/libro/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("listadoLibro", daoLibro.findAll());
        return "/view/bibliotecaria/libro/listar";
    }

    @PostMapping("/validar/isbn")
    public @ResponseBody boolean validarIsbn(@RequestParam String isbn , @RequestParam String edicion){
        boolean esUnico = true;
        if(daoLibro.findByIsbn(isbn) != null){
            esUnico = false;
        }
        return esUnico;
    }

}
