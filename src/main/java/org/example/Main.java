package main.java.org.example;

import main.java.org.example.model.Curso;
import main.java.org.example.model.Estudiante;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {

        List<Estudiante> estudiantes = new ArrayList<>();

        List<Curso> cursos = new ArrayList<>();

        estudiantes.add(new Estudiante(123456, 987654, "Juan", "Pérez", "2004/04/25", "matriculado"));

        estudiantes.add(new Estudiante(654321, 456789, "Ana", "Gómez", "2003/02/15", "Graduado"));

        estudiantes.add(new Estudiante(111222, 333444, "Luis", "Martínez", "2002/08/30", "matriculado"));

        cursos.add(new Curso(1, "Programación Java", "Curso de introducción a Java", 3, "1.0"));

        cursos.add(new Curso(2, "Desarrollo Web", "Curso sobre HTML, CSS y JavaScript", 4, "1.0"));

        cursos.add(new Curso(3, "Bases de Datos", "Curso de introducción a bases de datos SQL", 3, "1.0"));

        /*for (Estudiante estudiante : estudiantes) {

            estudiante.mostrarEstudiante();

        }*/

        for(Curso curso : cursos) {

            curso.mostrarCurso();

        }

    }
}