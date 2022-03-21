/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.dao;

import com.ina.ProyectoJavaFabricioJose.domain.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author josea
 */
public interface IProgramaDao extends JpaRepository<Programa, Integer> {
    
    public Iterable<Programa> findByNombreProgramaContains(String nombrePrograma);
    
}
