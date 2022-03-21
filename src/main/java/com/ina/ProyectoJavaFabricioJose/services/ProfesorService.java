/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.services;

import com.ina.ProyectoJavaFabricioJose.domain.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService implements IProfesorService {

    @Autowired
    private IProfesorService profesorService;

    @Override
    public void guardar(Profesor profesor) {
        try {
            profesorService.guardar(profesor);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Profesor profesor) {
        try {
            profesorService.eliminar(profesor);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Profesor> listar() {
        try {
            return profesorService.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Profesor> listar(String nombre) {
        try {
            return profesorService.listar(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Profesor obtenerProfesor(Integer idProfesor) {
        try {
            return profesorService.obtenerProfesor(idProfesor);
        } catch (Exception e) {
            throw e;
        }
    }

}
