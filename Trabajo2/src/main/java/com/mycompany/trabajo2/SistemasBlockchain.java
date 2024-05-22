/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo2;

import java.util.HashSet;

/**
 *
 * @author Usuario
 */
public class SistemasBlockchain {

    // Conjuntos para almacenar títulos, alumnos y la relación entre ambos
    public static HashSet<TituloAcademico> titulacionesguardadas = new HashSet<>();
    public static HashSet<Estudiante> alumnos = new HashSet<>();
    public static HashSet<RegistroTituloAlumno> alumnosTitulos = new HashSet<>();

    /**
     * Registra un título para un alumno en el sistema blockchain.
     *
     * @param titulo El título a registrar.
     * @param estudiante El estudiante al que pertenece el título.
     * @return Un mensaje indicando si el registro fue exitoso o no.
     */
    public String registrarTituloAlumno(TituloAcademico titulo, Estudiante estudiante) {
        // Verificar si el título ya está registrado para el estudiante
        for (RegistroTituloAlumno registro : alumnosTitulos) {
            if (registro.getTitulo().equals(titulo) && registro.getEstudiante().equals(estudiante)) {
                return "El título ya está registrado para este estudiante.";
            }
        }

        // Registrar el título
        alumnosTitulos.add(new RegistroTituloAlumno(titulo, estudiante));
        titulacionesguardadas.add(titulo);
        alumnos.add(estudiante);

        return "El título ha sido registrado exitosamente.";
    }

    /**
     * Verifica si un título pertenece a un estudiante en el sistema blockchain.
     *
     * @param titulo El título a verificar.
     * @param estudiante El estudiante al que pertenece el título.
     * @return true si el título pertenece al estudiante, false en caso contrario.
     */
    public boolean verificarTitulo(TituloAcademico titulo, Estudiante estudiante) {
        for (RegistroTituloAlumno registro : alumnosTitulos) {
            if (registro.getTitulo().equals(titulo) && registro.getEstudiante().equals(estudiante)) {
                return true;
            }
        }
        return false;
    }

    // Clase interna para representar la relación entre un título y un estudiante
    private static class RegistroTituloAlumno {
        private TituloAcademico titulo;
        private Estudiante estudiante;

        public RegistroTituloAlumno(TituloAcademico titulo, Estudiante estudiante) {
            this.titulo = titulo;
            this.estudiante = estudiante;
        }

        public TituloAcademico getTitulo() {
            return titulo;
        }

        public Estudiante getEstudiante() {
            return estudiante;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RegistroTituloAlumno that = (RegistroTituloAlumno) o;

            if (!titulo.equals(that.titulo)) return false;
            return estudiante.equals(that.estudiante);
        }

        @Override
        public int hashCode() {
            int result = titulo.hashCode();
            result = 31 * result + estudiante.hashCode();
            return result;
        }
    }
}
