/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.services;

import com.ina.ProyectoJavaFabricioJose.domain.DiaFeriado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ina.ProyectoJavaFabricioJose.dao.IFeriadoDao;

@Service
public class FeriadoService implements IFeriadoService {

    @Autowired
    private IFeriadoDao colectivoDao;

    @Override
    public int guardar(DiaFeriado colectivo) {
        int resultado = 1;
        try {
            colectivoDao.save(colectivo);
        } catch (Exception e) {
            resultado = 0;
        }

        return resultado;
    }

    @Override
    public int eliminar(DiaFeriado colectivo) {
        int resultado = 1;
        try {
            colectivoDao.delete(colectivo);
        } catch (Exception e) {
            resultado = 0;
        }

        return resultado;
    }

    @Override
    public List<DiaFeriado> listar() {
        return colectivoDao.findAll();
    }

    @Override
    public List<DiaFeriado> listar(int anio) {
        return (List<DiaFeriado>) colectivoDao.buscarPorAnio(anio);
    }

    @Override
    public DiaFeriado obtenerFeriado(int idDia) {
        return colectivoDao.getById(idDia);
    }

}
