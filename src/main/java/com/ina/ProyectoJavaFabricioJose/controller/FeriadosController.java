/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.controller;

import com.ina.ProyectoJavaFabricioJose.domain.DiaFeriado;
import com.ina.ProyectoJavaFabricioJose.services.FeriadoService;
import com.ina.ProyectoJavaFabricioJose.services.IMotivoService;
import com.ina.ProyectoJavaFabricioJose.services.MotivoService;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ina.ProyectoJavaFabricioJose.services.IFeriadoService;

@Controller
public class FeriadosController {
    
    @Autowired
    private IFeriadoService feriadoService;
    

    @GetMapping("/feriados")
    public String listaCliente(String txtTexto, Model model, @ModelAttribute("msg") String msg) {
        List<DiaFeriado> lista;
//        if (txtTexto == null) {
//            LocalDate fecha = LocalDate.now();
//            lista = colectivoService.listar(fecha.getYear());
//        }
//        else{
            lista = feriadoService.listar(Integer.parseInt(txtTexto));
//        }
        model.addAttribute("feriados", lista);
        return "listaDiasFeriados";
    }

    @PostMapping("/filtrarFeriados")
    public String filtar(String txtTexto, Model model) {
//        List<DiaColectivo> lista = colectivoService.listar(Integer.parseInt(txtTexto));
//        model.addAttribute("colectivos", lista);
        return "listaDiasFeriados";
    }

    @GetMapping("/nuevoFeriado")
    public String nuevo(DiaFeriado feriado) {

        return "feriado";
    }

    @PostMapping("/guardarFeriado")
    public String guardar(@Valid DiaFeriado feriado, RedirectAttributes redir) {
        String msg = "";

        if (feriadoService.guardar(feriado) != 0) {
            msg = "Día feriado insertado";
        } else {
            msg = "No se pudo insertar el día feriado";
        }

        redir.addFlashAttribute("msg", msg);

        return "redirect:/feriados";
    }

    @GetMapping("/editarFeriados/{idFeriado}")
    public String editar(DiaFeriado feriado, Model model, RedirectAttributes redir) {

        feriado = feriadoService.obtenerFeriado(feriado.getIdDia());
        if (feriado != null) {
            model.addAttribute("feriado", feriado);
            return "feriado";
        }
        String msg = "No se logró cargar el feriado";

        redir.addFlashAttribute("msg", msg);

        return "redirect:/feriados";
    }

    @GetMapping("/confirmarEliminacion/{idFeriado}")
    public String eliminar(DiaFeriado feriado, Model model, RedirectAttributes redir) {
        
        feriado = feriadoService.obtenerFeriado(feriado.getIdDia());
        if (feriado != null) {
            model.addAttribute("colectivo", feriado);
            return "eliminarFeriado";
        }
        String msg = "No se logró cargar el feriado";

        redir.addFlashAttribute("msg", msg);

        return "redirect:/feriados";
    }
    
    @PostMapping("/eliminarFeriado")
    public String eliminar(@Valid DiaFeriado feriado, RedirectAttributes redir) {
        String msg = "";

        if (feriadoService.eliminar(feriado) != 0) {
            msg = "Feriado eliminado";
        } else {
            msg = "No se pudo eliminar el feriado";
        }

        redir.addFlashAttribute("msg", msg);

        return "redirect:/feriados";
    }
    
}
