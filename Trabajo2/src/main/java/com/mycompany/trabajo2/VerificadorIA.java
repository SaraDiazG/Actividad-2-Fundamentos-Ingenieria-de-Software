/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class VerificadorIA {
    private int id_ia;
    
      public VerificadorIA(int idIa) {
        this.id_ia = idIa;
    }
     public void verificarAutentico(String enlace) {
        
        
        SistemasBlockchain sb = new SistemasBlockchain();
         boolean b = sb.verificar_titulo(enlace);
    if (b) {
        System.out.println("El código QR es auténtico.");
    } else {
        System.out.println("El código QR no es auténtico.");
    }
        
    }
}

