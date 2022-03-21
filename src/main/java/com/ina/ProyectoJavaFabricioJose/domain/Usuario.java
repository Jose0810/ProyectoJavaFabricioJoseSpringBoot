/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ina.ProyectoJavaFabricioJose.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID_USUARIO")
    private Long diUsuario;
    
    @Column(name = "NOMBRE_USUARIO")
    @NotEmpty(message="El Nombre del administrador es obligatorio")
    private String nombre;
    
    @Column(name = "APELLIDO1_USUARIO")
    @NotEmpty(message="El primer apellido del administrador es Obligatorio")
    private String apellido1;
    
    @Column(name = "APELLIDO2_USUARIO")
    private String apellido2;
    
    @Column(name = "CONTRASENIA")
    @NotEmpty(message="La contaseña es obligatoria")
    private String contrasenia;
    
    //Relación de uno a un centro 
    @OneToOne
    @JoinColumn(name = "ID_CENTRO")
    private Centro centroUsuario;
    
    //Relacion de un administrador a muchas asignaciones de usuario
    @OneToMany(mappedBy = "administradorUsuario")
    private List<UsuariosProfesores> usuarioPorfesor;
}
