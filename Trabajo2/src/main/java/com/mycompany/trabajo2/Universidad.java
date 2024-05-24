/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
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
    public String getNombre(){
     return this.nombre;
    }
    public HashSet<Estudiante> getAlumnos(){
    return this.alumnos;
    }
    
    //Creamos un titulo y lo añadimos a los titulos que dispone la universidad y a la blockchain
    public TituloAcademico emitir_titulo(){
        PersonalAdministrativo encargado_titulo = getPersonalAdministrativoAleatorio();
        Scanner s = new Scanner(System.in);
        int codigo_titulo = id_universidad + (titulaciones.size() + 1);
        
        System.out.println("El encargado de emitir este titulo es : " + encargado_titulo);
        
        System.out.println("Introduzca nombre de titulo: ");  
        String nombre_titulo = s.nextLine();
        //Comprobamos si el titulo esta ya en el listado de titulaciones de la universidad
        for (TituloAcademico titulo : titulaciones) {
            if (titulo.getNombre_titulo().equals(nombre_titulo)) {
                System.out.println("Ese titulo ya existe en el listado. ");
                 return null;
            }
        }
        
        TituloAcademico titulo = new TituloAcademico(codigo_titulo, nombre_titulo, id_universidad);
        titulaciones.add(titulo);
        titulo.registrarEnblockchain();
    return titulo;
    
    }
    
    //Creamos un estudiante y lo añadimos a los alumnos de la universidad y a la blockchain
    public Estudiante añadir_estudiante(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca nombre de alumno: ");  
        String nombre_alumno = s.nextLine();
        
        //Comprobamos si el alumno esta ya en el listado de titulaciones de la universidad
        for (Estudiante alumno : alumnos) {
            if (alumno.getNombre().equals(nombre_alumno)) {
                System.out.println("Ese alumno ya existe en el listado. ");
                 return null;
            }
        }
        System.out.println("Introduzca email de alumno: ");  
        String email_alumno = s.nextLine();

        Estudiante estudiante = new Estudiante(nombre_alumno, email_alumno);
        alumnos.add(estudiante);
        estudiante.registrar_blockchain();
        estudiante.solicitarTitulo();
        return estudiante;
 }

    /**
     * Para llenar la plantilla con datos de ejemplo
     */
    public void setPlantilla(List <PersonalAdministrativo> plantilla) {
        this.plantilla = plantilla;
    }
    public void setTitulaciones(HashSet <TituloAcademico> titulaciones) {
        this.titulaciones = titulaciones;
    }
    public void setEstudiantes(HashSet <Estudiante> estudiantes) {
        this.alumnos = estudiantes;
    }
    
    //Solo  a nivel de pruebas
    public PersonalAdministrativo getPersonalAdministrativoAleatorio() {
    if (plantilla.isEmpty()) {
        return null; // o lanzar una excepción si la lista está vacía
    }
    Random random = new Random();
    int indiceAleatorio = random.nextInt(plantilla.size());
    return plantilla.get(indiceAleatorio);
}
    
    
    
    
} 
