/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

import java.util.HashSet;

/**
 *
 * @author Usuario
 */
public class SistemasBlockchain {
    private int id_blockchain;
    
    private HashSet <TituloAcademico> titulacionesguardadas =  new HashSet<TituloAcademico>();
    private HashSet <Estudiante> alumnos =  new HashSet<TituloAcademico>();
    private HashSet <TituloAcademico> alumnos_titulos =  new HashSet<TituloAcademico>();
    
     public SistemasBlockchain(int idBlockchain) {
        this.id_blockchain = idBlockchain;
    }
    
    public String registrarTituloAlumno(TituloAcademico titulo, Estudiante estudiante) {
        if (titulacionesGuardadas.contains(titulo) && alumnos.contains(estudiante)) {
            alumnos_titulos.add(titulo);
            return "Título registrado correctamente";
        } else {
            return "Error al registrar el título";
        }
    }
    //Devuelve True si el titulo esta en la blockchain y el alumno lo tiene
    public boolean verificarTitulo(TituloAcademico titulo, Estudiante estudiante){
     return alumnos_tituloss.contains(titulo);
    
    }
    
    
}
