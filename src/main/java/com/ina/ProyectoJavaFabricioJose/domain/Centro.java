/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "CENTROS")
public class Centro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CENTRO")
    private int idCentro;
    
    @Column(name="NOMBRE", unique = true)
    @NotEmpty(message = "El nombre del centro es obligatorio")
    private String nombre;
    
    @Column(name="UBICACION", unique = true)
    @NotEmpty(message = "La ubicación del centro es obligatoria")
    private String ubicacion;
    
    //Relación de muchos centros a un distrito
    @JoinColumn(name = "ID_DISTRITO", nullable = false)
    @ManyToOne(optional = false)
    private Distrito distrito;
    
    //Relación de un centro a muchos profesores
    @OneToMany(mappedBy = "centroProfesor")
    private List<Profesor> profesores;
    
    //Relación de un centro a un adminitrador
    @OneToOne(mappedBy = "centroUsuario")
    private Usuario administrador;
    
    //Relación de un centro a muchos programas
    @OneToMany(mappedBy = "centros")
    private List<Programa> programa;
    
    //Relación de un centro a muchos días colectivos
    @OneToMany(mappedBy = "centroDiaColectivo")
    private List<DiasAusentesColectivos> diaColectivo;
    
    //Relación de un centro a muchos cronogramas
    @OneToMany(mappedBy = "centroCronograma")
    private List<Cronograma> cronograma;
    
}
