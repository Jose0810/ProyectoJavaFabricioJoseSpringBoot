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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "DIAS")
public class Dia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIA")
    private int idDia;

    @Column(name = "DIA")
    @NotEmpty(message = "El dia es obligatorio")
    private char dia;

    //Relación de muchos días a muchos programas
    @ManyToMany
    @JoinTable(name = "PROGRAMAS_DIAS", joinColumns = @JoinColumn(name = "ID_DIA"), inverseJoinColumns = @JoinColumn(name = "ID_PROGRAMA"))
    private List<Programa> programasDias;
    
    //Relación de muchos días a muchos programas
    @ManyToMany
    @JoinTable(name = "CRONOGRAMAS_DIAS", joinColumns = @JoinColumn(name = "ID_DIA"), inverseJoinColumns = @JoinColumn(name = "ID_PROGRAMA"))
    private List<Programa> cronogramaDiasPro;
    
    //Relación de muchos días a muchos modulos
    @ManyToMany
    @JoinTable(name = "CRONOGRAMAS_DIAS", joinColumns = @JoinColumn(name = "ID_DIA"), inverseJoinColumns = @JoinColumn(name = "ID_MODULO"))
    private List<Modulo> cronogramaDiasMod;
}
