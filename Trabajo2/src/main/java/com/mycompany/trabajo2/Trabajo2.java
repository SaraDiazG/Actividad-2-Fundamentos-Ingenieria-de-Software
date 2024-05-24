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
   
    HashSet <Universidad> universidades = new HashSet<>();
    public static void main(String[] args) {
        Trabajo2 app = new Trabajo2();
        // Universidades
        Universidad viu = new Universidad(001, "VIU");
        Universidad uclm = new Universidad(002, "UCLM");
        app.universidades.add(viu);
        app.universidades.add(uclm);

        // Creamos el personal administrativo de la universidad
        PersonalAdministrativo p1 = new PersonalAdministrativo(001, "Juan", viu);
        PersonalAdministrativo p2 = new PersonalAdministrativo(002, "Pepe", viu);
        PersonalAdministrativo p3 = new PersonalAdministrativo(003, "Antonio", viu);
        List<PersonalAdministrativo> plantilla = new ArrayList<>();
        plantilla.add(p1);
        plantilla.add(p2);
        plantilla.add(p3);
        viu.setPlantilla(plantilla);


        // Llamamos al menú principal
        app.menu();
    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.println("Bienvenido al menú de usuario sistema verificacion.");
            System.out.println("Por favor selecciona tu rol:");
            System.out.println("1. Alumno");
            System.out.println("2. Empleador");
            System.out.println("3. Universidad");
            System.out.println("0. Salir");

            int rol = s.nextInt();
            String nombre_estudiante;
            String nombre_universidad;
            switch (rol) {
                case 1:
                    System.out.println("Has elegido Estudiante. ");

                    System.out.println("Introduzca su nombre : ");
                    nombre_estudiante = s.next();
                    System.out.println("Seleccione la universidad : ");
                    nombre_universidad = s.next();

                    Estudiante estudiante = comprobar_estudiante(nombre_estudiante, nombre_universidad, universidades);
                    if (estudiante != null) {
                        System.out.println("Seleccione accion: ");
                        System.out.println("1. Compartir título.");
                        System.out.println("2. Solicitar título.");
                        System.out.println("3. Registrarse en sistema.");
                        opcion = s.nextInt();
                        
                        if (opcion == 1) {
                            estudiante.compartirTitulo();
                        } else if (opcion == 2) {
                            estudiante.compartirTitulo();
                        } else if (opcion == 3) {
                            estudiante.registrar_blockchain();
                        }
                    }
                    break;
                case 2: 
                    System.out.println("Has elegido empleador.");
                    Empleador e= new Empleador(001, "Informatica Antonio SL");
                    e.verificarTitulo();
                    
                case 3:
                    System.out.println("Has elegido Universidad. ");

                    System.out.println("Introduzca su nombre: ");
                    nombre_universidad= s.next();
                    Universidad  u = comprobar_universidad(nombre_universidad);  

                    
                    if (u != null) {
                        System.out.println("Seleccione accion: ");
                        System.out.println("1. Añadir estudiante.");
                        System.out.println("2. Solicitar título.");
                        System.out.println("3. Registrarse en sistema.");
                        opcion = s.nextInt();
                        
                        if (opcion == 1) 
                            u.añadir_estudiante();
                        else if (opcion == 2) 
                            u.emitir_titulo();
                        
                    }
                    break;
                    
                case 0:
                     System.out.println("Saliendo del sistema");
                s.close();
                System.exit(0);
                break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public Estudiante comprobar_estudiante(String nombre, String nombre_universidad, HashSet<Universidad> universidades) {
        for (Universidad uni : universidades) {
            if (uni.getNombre().equals(nombre_universidad)) {
                System.out.println("La universidad está en el listado.");
                for (Estudiante estudiante : uni.getAlumnos()) {
                    if (estudiante.getNombre().equals(nombre)) {
                        System.out.println("El estudiante está en el listado.");
                        return estudiante;
                    }
                }
            } else {
                System.out.println("La universidad no está en el listado.");
            }
        }
        System.out.println("El estudiante no está en el listado.");
        return null;
    }
    
    public Universidad comprobar_universidad(String nombre){
        for (Universidad uni : universidades){
            if(uni.getNombre().equals(nombre))
                    return uni; 
            else 
                System.out.println("La universidad no esta en el regsitro");
        }
     return null;
    }
}
