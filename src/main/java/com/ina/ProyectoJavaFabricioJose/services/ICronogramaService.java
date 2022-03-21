/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.services;

import com.ina.ProyectoJavaFabricioJose.domain.*;
import java.util.List;


public interface ICronogramaService {
    
    
    public Cronograma generarCronograma(Cronograma cronograma) throws Exception;
    
    public List<Cronograma> listarCronogramas(Integer idPrograma);

    public Cronograma obtenerCronograma(int idCronograma);
     
        
}
