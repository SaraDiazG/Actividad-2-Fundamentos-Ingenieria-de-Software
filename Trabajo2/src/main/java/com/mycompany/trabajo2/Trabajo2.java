/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajo2;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class Trabajo2 {
   
    public static HashSet <Universidad> universidades = new HashSet<>();
    public static void main(String[] args) {
        Trabajo2 app = new Trabajo2();
        
        // Universidades
        Universidad viu = new Universidad(001, "VIU");
        Universidad uclm = new Universidad(002, "UCLM");
        universidades.add(viu);
        universidades.add(uclm);
        

        // Creamos el personal administrativo de la universidad
        PersonalAdministrativo p1 = new PersonalAdministrativo(001, "Juan", viu);
        PersonalAdministrativo p2 = new PersonalAdministrativo(002, "Pepe", viu);
        PersonalAdministrativo p3 = new PersonalAdministrativo(003, "Antonio", viu);
        List<PersonalAdministrativo> plantilla = new ArrayList<>();
        plantilla.add(p1);
        plantilla.add(p2);
        plantilla.add(p3);
        viu.setPlantilla(plantilla);
        
        
        TituloAcademico titulo1 = new TituloAcademico(1, "Ingenieria Informatica", 001);
        TituloAcademico titulo2 = new TituloAcademico(2, "Ingenieria Comandante", 001);
        TituloAcademico titulo3 = new TituloAcademico(3, "Ingenieria Electrica", 001);
        Estudiante s1 = new Estudiante ("Francisco Espada", "franciscoespada@gmail.com");
        Estudiante s2 = new Estudiante ("Sara Dias", "saradiaz@gmail.com");
        HashSet <TituloAcademico> titulaciones = new HashSet<>();
        HashSet <Estudiante> estudiantes = new HashSet<>();
        titulaciones.add(titulo1);
        titulaciones.add(titulo2);
        titulaciones.add(titulo3);
        estudiantes.add(s1);
        estudiantes.add(s2);
        viu.setEstudiantes(estudiantes);
        viu.setTitulaciones(titulaciones);
         
                 //Uniones aleatorias
        SistemasBlockchain s = new SistemasBlockchain();
        TituloAcademico t1 = s.getTituloAleatorio();
        TituloAcademico t2 = s.getTituloAleatorio();
        TituloAcademico t3 = s.getTituloAleatorio();
        Estudiante a1 = s.getEstudianteAleatorio();
        Estudiante a2 = s.getEstudianteAleatorio();
        
      
        
        
  
        
        // Llamamos al menú principal
        app.menu();
    }

    public void menu() {
        
        
        int opcion;
        while (true) {
            System.out.println("Bienvenido al menú de usuario sistema verificacion.");
            System.out.println("Por favor selecciona tu rol:");
            System.out.println("1. Alumno");
            System.out.println("2. Empleador");
            System.out.println("3. Universidad");
            System.out.println("0. Salir");

            int rol =  new Scanner(System.in).nextInt();
            String nombre_estudiante;
            String nombre_universidad;
            switch (rol) {
                case 1:
     System.out.println("Has elegido Estudiante. ");
    System.out.println("Seleccione la universidad : ");
    nombre_universidad = new Scanner(System.in).next();
    Universidad uni = comprobar_universidad(nombre_universidad, universidades);
    if (uni != null) {
        System.out.println("Introduzca su nombre : ");
        nombre_estudiante = new Scanner(System.in).next();
        Estudiante estudiante = comprobar_estudiante(nombre_estudiante, uni);
        if (estudiante != null) {
            System.out.println("Seleccione accion: ");
            System.out.println("1. Compartir título.");
            System.out.println("2. Solicitar título.");
            System.out.println("3. Registrarse en sistema.");
            opcion = new Scanner(System.in).nextInt();
            if (opcion == 1) {
                estudiante.compartirTitulo();
            } else if (opcion == 2) {
                estudiante.compartirTitulo();
            } else if (opcion == 3) {
                estudiante.registrar_blockchain();
            }
        } else {
            System.out.println("El estudiante no se encuentra en la universidad.");
        }
    }
    break;
                case 2: 
                    System.out.println("Has elegido empleador.");
                    Empleador e= new Empleador(001, "Informatica Antonio SL");
                    e.verificarTitulo();
                   break; 
                case 3:
                    System.out.println("Has elegido Universidad. ");

                    System.out.println("Introduzca su nombre: ");
                    nombre_universidad= new Scanner(System.in).next();
                    Universidad  u = comprobar_universidad(nombre_universidad,universidades );  

                    
                    if (u != null) {
                        System.out.println("Seleccione accion: ");
                        System.out.println("1. Añadir estudiante.");
                        System.out.println("2. Emitir titulo.");
                        
                        opcion = new Scanner(System.in).nextInt();
                        
                        if (opcion == 1) 
                            u.añadir_estudiante();
                        else if (opcion == 2) 
                            u.emitir_titulo();
                        
                    }
                    break;
                    
                case 0:
                     System.out.println("Saliendo del sistema");
                
                System.exit(0);
                break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
public Estudiante comprobar_estudiante(String nombre, Universidad uni) {
    Estudiante estudiante = null;
    for (Estudiante e : uni.getAlumnos()) {
        if (e.getNombre().equals(nombre)) {
            System.out.println("El estudiante está en el listado.");
            estudiante = e;
            break;
        }
    }
    return estudiante;
}
    
  public Universidad comprobar_universidad(String nombre, HashSet<Universidad> universidades){
    Universidad uni = null;
    for (Universidad u : universidades){
        if(u.getNombre().equals(nombre)){
            uni = u;
            break;
        }
    }
    if (uni == null) {
        System.out.println("La universidad no esta en el regsitro");
    }
    return uni;
}
}
