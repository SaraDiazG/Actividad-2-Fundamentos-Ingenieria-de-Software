/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Universidad {
    private String nombre;
    private int id_universidad;
    private List <PersonalAdministrativo> plantilla = new ArrayList();     
    //Usamos un set para que no se dupliquen las titulaciones de una universidad
    private HashSet <TituloAcademico> titulaciones = new HashSet<TituloAcademico>();
    
     public Universidad(int idUniversidad, String nombre) {
        this.id_universidad = idUniversidad;
        this.nombre = nombre;
    }
    
    
     
    public TituloAcademico emitirTitulo(PersonalAdministrativo encargado_titulo){
        Scanner s = new Scanner(System.in);
        int codigo_titulo = titulaciones.size() + 1;
        
        System.out.println("El encargado de emitir este titulo es : " + encargado_titulo);
        
        System.out.println("Introduzca nombre de titulo: ");  
        String nombre_titulo = s.nextLine();
        //Comprobamos si el titulo esta ya en el listado de titulaciones de la universidad
        if (titulaciones.contains(new TituloAcademico(0, nombre_titulo, id_universidad))){
            System.out.println("Ese titulo ya existe en el listado. ");
            return null;
        }
        
        TituloAcademico titulo = new TituloAcademico(codigo_titulo, nombre_titulo, id_universidad);
        titulaciones.add(titulo);
    
    return titulo;
    
    }

    /**
     * Para llenar la plantilla con datos de ejemplo
     */
    public void setPlantilla(List <PersonalAdministrativo> plantilla) {
        this.plantilla = plantilla;
    }
    
    
    
    
    
    
}
