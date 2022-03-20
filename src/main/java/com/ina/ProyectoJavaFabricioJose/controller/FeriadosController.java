/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.controller;

import com.ina.ProyectoJavaFabricioJose.domain.DiaFeriado;
import com.ina.ProyectoJavaFabricioJose.domain.Motivo;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
public class FeriadosController {

    @Autowired
    private IFeriadoService feriadoService;

    @Autowired
    private IMotivoService motivoService;

    @GetMapping("/feriados")
    public String listaCliente(String txtTexto, Model model) {

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        List<DiaFeriado> lista;
        lista = feriadoService.listar(String.valueOf(year));
        model.addAttribute("feriados", lista);
        model.addAttribute("year", year);
        return "listaDiasFeriados";

    }

    @PostMapping("/filtrarFeriados")
    public String filtar(String txtTexto, Model model) {
        List<DiaFeriado> lista = feriadoService.listar(txtTexto);
        model.addAttribute("feriados", lista);
        return "listaDiasFeriados";
    }

    @GetMapping("/nuevoFeriado")
    public String nuevo(DiaFeriado feriado, Model model) {

        List<Motivo> lista = motivoService.listar();

        model.addAttribute("motivos", lista);

        return "feriado";
    }

    @PostMapping("/guardarFeriado")
    public String guardar(@Valid DiaFeriado feriado, RedirectAttributes redir) {
        String msg = "";

        Calendar cal = null;
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        feriado.getFecha() = (Date) formatter.parse(feriado.getFecha().toString());
        cal = Calendar.getInstance();
        cal.setTime(feriado.getFecha());

        if (feriadoService.fechaRepetida(fecha).isEmpty()) {
            if (feriadoService.motivoRepetido(feriado.getMotivo().getIdMotivo()).isEmpty()) {
                if (feriadoService.guardar(feriado) != 0) {
                    msg = "Día feriado insertado";
                } else {
                    msg = "No se pudo insertar el día feriado";
                }
            } else {
                msg = "No se pudo insertar, ya existe ese motivo para esa año";
            }
        } else {
            msg = "No se pudo insertar, ya que existe un día feriado con esa fecha";
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
