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
    //Usamos un set para que no se dupliquen las titulaciones de una universidad y los alumnos
    private HashSet <TituloAcademico> titulaciones = new HashSet<TituloAcademico>();
    private HashSet <Estudiante> alumnos = new HashSet<Estudiante>();
    
     public Universidad(int idUniversidad, String nombre) {
        this.id_universidad = idUniversidad;
        this.nombre = nombre;
    }
    
    
    //Creamos un titulo y lo añadimos a los titulos que dispone la universidad y a la blockchain
    public TituloAcademico emitirTitulo(PersonalAdministrativo encargadoTitulo){
        Scanner s = new Scanner(System.in);
        int codigoTitulo = titulaciones.size() + 1;
        
        System.out.println("El encargado de emitir este titulo es : " + encargadoTitulo);
        
        System.out.println("Introduzca nombre de titulo: ");  
        String nombreTitulo = s.nextLine();
        //Comprobamos si el titulo esta ya en el listado de titulaciones de la universidad
        for (TituloAcademico titulo : titulaciones) {
            if (titulo.getNombre_titulo().equals(nombreTitulo)) {
                System.out.println("Ese titulo ya existe en el listado. ");
                 return null;
            }
        }
        
        TituloAcademico titulo = new TituloAcademico(codigoTitulo, nombreTitulo, id_universidad);
        titulaciones.add(titulo);
        titulo.registrarEnblockchain();
    return titulo;
    
    }
    
    //Creamos un estudiante y lo añadimos a los alumnos de la universidad y a la blockchain
    public Estudiante añadirEstudiante(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca nombre de alumno: ");  
        String nombreAlumno = s.nextLine();
        
        //Comprobamos si el alumno esta ya en el listado de titulaciones de la universidad
        for (Estudiante alumno : alumnos) {
            if (alumno.getNombre().equals(nombreAlumno)) {
                System.out.println("Ese alumno ya existe en el listado. ");
                 return null;
            }
        }
        System.out.println("Introduzca email de alumno: ");  
        String email_alumno = s.nextLine();

        Estudiante estudiante = new Estudiante(nombreAlumno, email_alumno);
        alumnos.add(estudiante);
        estudiante.registrar_blockchain();
        
        return estudiante;
 }

    /**
     * Para llenar la plantilla con datos de ejemplo
     */
    public void setPlantilla(List <PersonalAdministrativo> plantilla) {
        this.plantilla = plantilla;
    }
    
    
    
    
    
    
}
