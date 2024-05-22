/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajo2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Trabajo2 {

    public static void main(String[] args) {
        System.out.println("Datos de ejemplo");
        
        //Universidades
        List <Universidad> universidades = new ArrayList();
        Universidad viu = new Universidad (001, "VIU");
        Universidad uclm = new Universidad (002, "UCLM");
        universidades.add(viu); universidades.add(uclm);
        
        
        // Creamos el personal administrativo de la universidad
        PersonalAdministrativo p1 = new PersonalAdministrativo(001, "Juan", viu);
        PersonalAdministrativo p2 = new PersonalAdministrativo(002, "Pepe", viu);
        PersonalAdministrativo p3 = new PersonalAdministrativo(003, "Antonio", viu);
        List <PersonalAdministrativo> plantilla = new ArrayList();
        plantilla.add(p1);plantilla.add(p2);plantilla.add(p3);
        viu.setPlantilla(plantilla);
        

        
    }
    
    
}
