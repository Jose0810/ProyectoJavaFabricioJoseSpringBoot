/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.services;

import com.ina.ProyectoJavaFabricioJose.dao.ICronogramaDao;
import com.ina.ProyectoJavaFabricioJose.domain.Cronograma;
import com.ina.ProyectoJavaFabricioJose.domain.Modulo;
import com.ina.ProyectoJavaFabricioJose.domain.Programa;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CronogramaService implements ICronogramaService{

    @Autowired
    private ICronogramaDao cronogramaDao;
   
    @Override
    public Cronograma generarCronograma(Cronograma cronograma) throws Exception {
        try {
            int retorno = 0;
            HashMap resultado = cronogramaDao.generarCronograma(cronograma.getModuloCronograma().getIdModulo(), cronograma.getProgramaCronograma().getIdPrograma(), cronograma.getHorasDia(),
                    cronograma.getHorasInicio(), cronograma.getHoraFin(), cronograma.getEstado(), cronograma.getCentroCronograma().getIdCentro(), cronograma.getFechaInicio(), cronograma.getRetorno());
                    
            cronograma.setFechaInicio((Date)resultado.get("FECHA_INICIO"));
            cronograma.setRetorno((Integer)resultado.get("retorno"));
            
        } catch (Exception e) {
            throw e;
        }
        
        return cronograma;
    }

    @Override
    public List<Cronograma> listarCronogramas(Integer idPrograma) {
        try{
            List<Cronograma> lista = (List<Cronograma>) cronogramaDao.findByIdProgramaContains(idPrograma);
            return lista;
        }catch(Exception e){
            throw e;
        }
        
    }


    @Override
    public Cronograma obtenerCronograma(int idCronograma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
