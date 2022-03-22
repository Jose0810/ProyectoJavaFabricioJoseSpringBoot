/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.controller;

import com.ina.ProyectoJavaFabricioJose.domain.Programa;
import com.ina.ProyectoJavaFabricioJose.services.ICronogramaService;
import com.ina.ProyectoJavaFabricioJose.services.IModuloService;
import com.ina.ProyectoJavaFabricioJose.services.IProfesorService;
import com.ina.ProyectoJavaFabricioJose.services.IProgramaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CronogramaController {

    @Autowired
    private IProgramaService programaService;

    @Autowired
    private ICronogramaService cronogramaService;

    @Autowired
    private IModuloService moduloService;

    @Autowired
    private IProfesorService profesorService;
    
    @GetMapping
    public String listar(Model model){
        
        List<Programa> programasConCronograma = programaService.listarProgramasConCronogramas();
        
        model.addAttribute("programas", programasConCronograma);
        
        return "buscarCronogramas";
    }

}
