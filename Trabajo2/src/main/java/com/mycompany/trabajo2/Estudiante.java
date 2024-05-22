/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;
import java.util.ArrayList;
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
    private List <TituloAcademico> titulos = new ArrayList();
    
    
    public Estudiante(String nombre, String email) {
        this.id_estudiante = ThreadLocalRandom.current().nextInt(10000000, 100000000);;
        this.nombre = nombre;
        this.email = email;
    }
    
    
    public void registrar_blockchain(){
    
    SistemasBlockchain.alumnos.add(this);
    
    }
    public TituloAcademico solicitarTitulo(){
        return null;
    
    }
    
    public void compartirTitulo(){
        System.out.println("El alumno entrega de manera fisica o telematicamente sus titulos y codigos QR al empleador"); //aca esto se podría ver mejor como el envio de un link, no?
    
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

    //Algunos metodos para agregar eliminar o recuperar titulos

    public void agregarTitulo(TituloAcademico titulo) {
        titulos.add(titulo);
    }

    public void eliminarTitulo(TituloAcademico titulo) {
        titulos.remove(titulo);
    }

    public List<TituloAcademico> getTitulos() {
        return titulos;
    }
    
}
