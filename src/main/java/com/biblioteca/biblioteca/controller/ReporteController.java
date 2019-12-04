package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.EstadisticaLibroMasPrestaPorBiblioteca;
import com.biblioteca.biblioteca.model.EstadisticaPrestamosPorDia;
import com.biblioteca.biblioteca.model.Prestamo;
import com.biblioteca.biblioteca.service.LibroMasPrestadoPorBibliotecaService;
import com.biblioteca.biblioteca.service.PrestamoService;
import com.biblioteca.biblioteca.service.PrestamosPorDiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ReporteController.BASE_URL)
public class ReporteController {


    public static final String BASE_URL = "/reporte";

    @Autowired
    private LibroMasPrestadoPorBibliotecaService daoLibroReporte;

    @Autowired
    private PrestamosPorDiaService daoPrestamoPorDia;

    @GetMapping("/libro-mas-prestado-por-biblioteca")
    public List<EstadisticaLibroMasPrestaPorBiblioteca> ReporteLibroMasPrestadoPorBiblioteca(){
       return daoLibroReporte.libroMasPrestadoPorBiblioteca();
    }

    @GetMapping("/libro-mas-prestado")
    public List<EstadisticaLibroMasPrestaPorBiblioteca> ReporteLibroMasPrestado(){
        return daoLibroReporte.libroMasPrestado();
    }

    @GetMapping("/prestamos-por-dia")
    public List<EstadisticaPrestamosPorDia> ReportePrestamosPorDia(){
        return daoPrestamoPorDia.prestamosPorDia();
    }
}
