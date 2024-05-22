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
    private int id_titulo;
    private String nombre_titulo;
    private LocalDateTime fecha_emision;
    private String codigoQR;
    private int id_blockchain;
    
    
    
    public TituloAcademico(int idTitulo, String nombreTitulo, int id_blockchain) {
        this.id_titulo = idTitulo;
        this.nombre_titulo = nombreTitulo;
        this.fecha_emision = LocalDateTime.now();
        this.codigoQR = generarQR();
        //Cada universidad tendra su blockchain
        this.id_blockchain = id_blockchain;
    }
    
    //Generamos un codigo de 6 digitos alfanumerico
    public String generarQR(){
    
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();
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
    
    
    
    public void registrarEnblockchain(){
     
    
    
    }
    
    }
   

   
    

