/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "ASIGNACION_PROFESOR")
public class AsignacionProfesor implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASIGNACION_PROFESOR")
    private int idAsignacionProfesor;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "FECHA_FIN")
    private Date fechaFin;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    
    //Relación de muchas asignaciones a un profesor
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    @ManyToOne(optional = false)
    private Profesor profesorAsignacion;
    
    //Relación de muchas asignaciones a un módulo
    @JoinColumn(name = "ID_MODULO", nullable = false)
    @ManyToOne(optional = false)
    private Modulo moduloAsignacionPr;
    
     //Relación de muchas asignaciones a un programa
    @JoinColumn(name = "ID_PROGRAMA", nullable = false)
    @ManyToOne(optional = false)
    private Programa programaAsignacionPr;
    
    
}
