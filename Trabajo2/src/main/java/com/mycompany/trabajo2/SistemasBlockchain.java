 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 *
 * @author Usuario
 */
public class SistemasBlockchain {

    /**
     * @param aTitulacionesguardadas the titulacionesguardadas to set
     */
    public static void setTitulacionesguardadas(HashSet <TituloAcademico> aTitulacionesguardadas) {
        titulacionesguardadas = aTitulacionesguardadas;
    }

    /**
     * @param aAlumnos the alumnos to set
     */
    public static void setAlumnos(HashSet <Estudiante> aAlumnos) {
        alumnos = aAlumnos;
    }
    
    
    private static HashSet <TituloAcademico> titulacionesguardadas =  new HashSet<TituloAcademico>();
    private static HashSet <Estudiante> alumnos =  new HashSet<Estudiante>();
    private static HashMap<Integer, HashMap<Integer, String>> alumno_titulos= new HashMap();
   
   
    //Asignamos una union alumno-tiulaciones, comprueba si el titulo y el alumno estan en sus blockchain y despues los une, si no esta ese alumno lo registra.
    public void registrar_titulo_alumno(TituloAcademico titulo, Estudiante estudiante) {
       int id_estudiante = estudiante.getId_estudiante();
       int id_titulo = titulo.getId_titulo();
       String codigoQR = id_titulo + "-" + id_estudiante;
       
       
       //Comprobamos si el alumno esta en el listado
       if (!alumnos.contains(estudiante)) {
             System.out.println("El alumno no esta en el listado");
        }//Comprobamos si el titulo esta en el listado
          if (!titulacionesguardadas.contains(titulo)) {
              System.out.println("El título no está en el conjunto de titulaciones guardadas.");
        }//Si la conexion no existe crea el alumno
        if (!alumno_titulos.containsKey(id_estudiante)) {
            getAlumno_titulos().put(id_estudiante, new HashMap<Integer, String>());
        }
        //Creamos el registro
        getAlumno_titulos().get(id_estudiante).put(id_titulo, codigoQR);
        System.out.println("Conexion creada con exito.");

    }
    //Devuelve True si el titulo QR esta en el listado
    public boolean verificar_titulo(String codigoQR){
        
        for (HashMap<Integer, String> map : getAlumno_titulos().values()) {
            if (map.containsValue(codigoQR)) {
                return true;
            }
        }
        return false;  
        
    }
    
 // Funciones solo visuales 
    public static TituloAcademico getTituloAleatorio() {
    if (getTitulacionesguardadas().isEmpty()) {
        return null; // o lanzar una excepción si deseas
    }
    List<TituloAcademico> lista = new ArrayList<>(getTitulacionesguardadas());
    Random random = new Random();
    int index = random.nextInt(lista.size());
    return lista.get(index);
}
    public static Estudiante getEstudianteAleatorio() {
    if (getAlumnos().isEmpty()) {
        return null; // o lanzar una excepción si deseas
    }
    List<Estudiante> lista = new ArrayList<>(getAlumnos());
    Random random = new Random();
    int index = random.nextInt(lista.size());
    return lista.get(index);
    }

    /**
     * @return the titulacionesguardadas
     */
    public static HashSet <TituloAcademico> getTitulacionesguardadas() {
        return titulacionesguardadas;
    }

    /**
     * @return the alumnos
     */
    public static HashSet <Estudiante> getAlumnos() {
        return alumnos;
    }

    /**
     * @return the alumno_titulos
     */
    public static HashMap<Integer, HashMap<Integer, String>> getAlumno_titulos() {
        return alumno_titulos;
    }
    
        
}
    


     

