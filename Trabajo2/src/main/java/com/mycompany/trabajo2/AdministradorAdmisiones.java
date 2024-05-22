/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

/**
 *
 * @author Usuario
 */
public class AdministradorAdmisiones extends PersonalAdministrativo {
    
    
    public AdministradorAdmisiones(int id_personal, String nombre, Universidad universidad_empleo) {
        super(id_personal, nombre, universidad_empleo);
    }

    @Override
    public boolean verificarTitulo(TituloAcademico titulo) {
        // Implementación específica para verificar un título académico
        return false;
    }
}

