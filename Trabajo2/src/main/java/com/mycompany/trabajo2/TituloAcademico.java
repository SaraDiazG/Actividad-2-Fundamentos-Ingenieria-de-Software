 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

import java.time.LocalDateTime;
import java.util.Random;

/**    
 *
 * @author Usuario
 */
public class TituloAcademico {

    /**
     * @return the id_titulo
     */
    public int getId_titulo() {
        return id_titulo;
    }

    /**
     * @return the nombre_titulo
     */
    public String getNombre_titulo() {
        return nombre_titulo;
    }

    /**
     * @return the fecha_emision
     */
    public LocalDateTime getFecha_emision() {
        return fecha_emision;
    }

    /**
     * @return the codigoQR
     */
    
    
    
    private int id_titulo;
    private String nombre_titulo;
    private LocalDateTime fecha_emision;
    private int id_universidad;
    
    
    
    public TituloAcademico(int idTitulo, String nombreTitulo, int id_universidad) {
        this.id_titulo = idTitulo;
        this.nombre_titulo = nombreTitulo;
        this.fecha_emision = LocalDateTime.now();
    
        this.id_universidad = id_universidad;
    }

    //Registramos el titulo en la blockchain
    public void registrarEnblockchain(){
    
    SistemasBlockchain.getTitulacionesguardadas().add(this);
    
    
    }
    
    }
   

   
    

