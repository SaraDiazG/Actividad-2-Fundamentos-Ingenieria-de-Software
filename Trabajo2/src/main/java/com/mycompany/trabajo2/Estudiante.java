/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Usuario
 */
public class Estudiante {
    private String nombre;
    private int id_estudiante;
    private String email;
    private List <String> titulos = new ArrayList();
    
    
    public Estudiante(String nombre, String email) {
        this.id_estudiante = ThreadLocalRandom.current().nextInt(10000000, 100000000);;
        this.nombre = nombre;
        this.email = email;
        this.titulos = solicitarTitulo();
    }
    
    
    public void registrar_blockchain(){
    
    SistemasBlockchain.alumnos.add(this);
    
    }
    public List<String> solicitarTitulo(){
    List<String> codigosQR = new ArrayList<>();
    // Comprobamos si el alumno está en el listado
    
    if (SistemasBlockchain.alumnos.contains(this)) {
        // Obtenemos los titulos y los codigos QR asociados al id_alumno
        HashMap<Integer, String> titulosAlumno = SistemasBlockchain.alumno_titulos.get(this.id_estudiante);
        //Si titulosAlumnos tiene titulos guardo los QR
        if (titulosAlumno != null) {
            codigosQR.addAll(titulosAlumno.values());
        }
    } else {
        System.out.println("El alumno no está en el listado");
    }
    return codigosQR;
 }
    
    
    
    public void compartirTitulo(){
        System.out.println("El alumno entrega de manera fisica o telematicamente sus titulos y codigos QR al empleador");
    
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
    
}
