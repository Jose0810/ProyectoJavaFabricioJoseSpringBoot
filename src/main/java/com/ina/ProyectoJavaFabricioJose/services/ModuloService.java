/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.services;

import com.ina.ProyectoJavaFabricioJose.dao.IModuloDao;
import com.ina.ProyectoJavaFabricioJose.domain.Modulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuloService implements IModuloService {

    @Autowired
    private IModuloDao moduloDao;

    @Override
    public void guardar(Modulo modulo) {
        try {
            moduloDao.save(modulo);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Modulo modulo) {
        try {
            moduloDao.delete(modulo);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Modulo> listar() {
        try {
            return moduloDao.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Modulo> listar(String nombreModulo) {
        try {
            return (List<Modulo>) moduloDao.findByNombreModuloContains(nombreModulo);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Modulo obtenerModulo(Integer idModulo) {
        try {
            return moduloDao.findById(idModulo).orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }

}
