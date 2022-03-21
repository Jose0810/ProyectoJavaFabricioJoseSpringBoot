/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.services;

import com.ina.ProyectoJavaFabricioJose.dao.IProgramaDao;
import com.ina.ProyectoJavaFabricioJose.domain.Programa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramaService implements IProgramaService{
    
    @Autowired
    private IProgramaDao programaDao;

    @Override
    public void guardar(Programa programa) {
        try {
            programaDao.save(programa);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Programa programa) {
        try {
            programaDao.delete(programa);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Programa> listar() {
        try {
            return programaDao.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Programa> listar(String nombrePrograma) {
        try {
            return (List<Programa>) programaDao.findByNombreProgramaContains(nombrePrograma);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Programa obtenerModulo(Integer idPrograma) {
        try {
            return programaDao.findById(idPrograma).orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
