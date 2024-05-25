 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Usuario
 */
public class Estudiante {
    private static final Random random = new Random();
    private String nombre;
    private int id_estudiante;
    private String email;
    private HashSet <String> titulos = new HashSet();
    

    public Estudiante(String nombre, String email) {
        this.id_estudiante = random.nextInt(10000);
        this.nombre = nombre;
        this.email = email;
        
    }
    
    
    public void registrar_blockchain(){
    
    
    SistemasBlockchain.getAlumnos().add(this);
    System.out.println("Esta usted registrado en el sistema BlockChain.");
    }
    
    
    public void verTitulos(){
    for (String codigo: titulos){
        System.out.println("Codigo :" + codigo);
    }
    
    }
    
    public void solicitarTitulo() {
    // Comprobamos si el alumno está en el listado
    HashMap<Integer, HashMap<Integer, String>> titulaciones = SistemasBlockchain.getAlumno_titulos();
    if (titulaciones.containsKey(this.id_estudiante)) {
        // Obtenemos los titulos y los codigos QR asociados al id_alumno
        HashMap<Integer, String> titul_codigo = titulaciones.get(this.id_estudiante);
        //Si titulosAlumnos tiene titulos guardo los QR
        if (titul_codigo != null) {
            this.titulos.clear(); 
            this.titulos.addAll(titul_codigo.values()); 
        }
    } else {
        System.out.println("El alumno no está en el listado");
    }
}
    
    
    
    public void compartirTitulo(){
        System.out.println("El alumno entrega de manera fisica o telematicamente sus titulos y codigos QR al empleador");
        if (titulos != null){
        System.out.println("Listas de codigosQR: ");
         
        for (String titulo : titulos) {
            System.out.println("Codigo : "  + titulo );
            
    }
        }else {
            System.out.println("No hay ningun titulo en el listado");
             }
            Trabajo2 t = new Trabajo2();
            t.menu();
       
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the id_estudiante
     */
    public int getId_estudiante() {
        return id_estudiante;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    //Solo con fines de hacer pruebas
    

    
}
