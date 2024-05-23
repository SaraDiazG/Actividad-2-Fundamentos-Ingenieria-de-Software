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
public class Empleador {
    
     private String nombre;
     private int id_empleador;
     
     public void verificarTitulo(){
         Scanner s = new Scanner(System.in);
         System.out.println("Introduzca codigo QR: ");
        String enlace = s.nextLine();
        
         VerificadorIA v = new VerificadorIA(1);
         v.verificarAutentico(enlace);
     
     
     }
     
      public Empleador(int idEmpleador, String nombre) {
        this.id_empleador = idEmpleador;
        this.nombre = nombre;
    }
      
      
    
}
