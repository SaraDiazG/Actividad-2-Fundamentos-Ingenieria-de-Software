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
    public String getCodigoQR() {
        return codigoQR;
    }
    
    
    
    
    
    private int id_titulo;
    private String nombre_titulo;
    private LocalDateTime fecha_emision;
    private String codigoQR;
    private int id_universidad;
    
    
    
    public TituloAcademico(int idTitulo, String nombreTitulo, int id_universidad) {
        this.id_titulo = idTitulo;
        this.nombre_titulo = nombreTitulo;
        this.fecha_emision = LocalDateTime.now();
        this.codigoQR = generarQR();
        this.id_universidad = id_universidad;
    }
    
    //Generamos un codigo de 6 digitos alfanumerico y que comienza con id de la universidad al que pertenece
    public String generarQR(){
    
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();
        //El codigo empieza con el id de la universidad
        codigo.append(id_universidad);
        // Generamos un codigo aleatorio de numeros y letras de 6 caracteres
        for (int i = 0; i < 6; i++) {
            int randomInt = random.nextInt(10);
            if (randomInt == 0 && i == 0) {
                i--;
                continue;
            }
            char randomChar;
            if (randomInt < 2) {
                randomInt += 65 - 2; // Generar un carácter entre A y Z
            } else {
                randomInt += 48; // Generar un dígito entre 0 y 9
            }
            randomChar = (char) randomInt;
            codigo.append(randomChar);
        }

        return codigo.toString();
    }
    
    
    //Registramos el titulo en la blockchain
    public void registrarEnblockchain(){
    
    SistemasBlockchain.titulacionesguardadas.add(this);
    
    
    }
    
    }
   

   
    

