package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.EstadisticaLibroMasPrestaPorBiblioteca;
import com.biblioteca.biblioteca.model.EstadisticaPrestamosPieChart;
import com.biblioteca.biblioteca.model.EstadisticaPrestamosPorMes;
import com.biblioteca.biblioteca.service.EstadisticaPrestamosPieChartService;
import com.biblioteca.biblioteca.service.LibroMasPrestadoPorBibliotecaService;
import com.biblioteca.biblioteca.service.PrestamosPorMesService;
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
    private PrestamosPorMesService daoPrestamoPorDia;

    @Autowired
    private EstadisticaPrestamosPieChartService daoPrestamoPieChart;

    @GetMapping("/libro-mas-prestado-por-biblioteca")
    public List<EstadisticaLibroMasPrestaPorBiblioteca> ReporteLibroMasPrestadoPorBiblioteca(){
       return daoLibroReporte.libroMasPrestadoPorBiblioteca();
    }

    @GetMapping("/libro-mas-prestado")
    public List<EstadisticaLibroMasPrestaPorBiblioteca> ReporteLibroMasPrestado(){
        return daoLibroReporte.libroMasPrestado();
    }

    @GetMapping("/prestamos-por-mes")
    public List<EstadisticaPrestamosPorMes> ReportePrestamosPorMes(){
        return daoPrestamoPorDia.prestamosPorMes();
    }

    @GetMapping("/prestamos-pier-chart")
    public List<EstadisticaPrestamosPieChart> ReportePrestamosPieChart(){
        return daoPrestamoPieChart.prestamosPieChart();
    }
}
