/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class Estudiante {
    private String nombre;
    private int id_estudiante;
    private String email;
    private List <TituloAcademico> titulos = new ArrayList();
    
    
    public Estudiante(int idEstudiante, String nombre, String email) {
        this.id_estudiante = idEstudiante;
        this.nombre = nombre;
        this.email = email;
    }
    
    
    
    public TituloAcademico solicitarTitulo(){
        return null;
    
    }
    
    public TituloAcademico compartirTitulo(){
        return null;
    
    }
    
}
