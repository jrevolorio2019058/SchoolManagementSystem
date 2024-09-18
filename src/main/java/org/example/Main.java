package main.java.org.example;

import main.java.org.example.model.Estudiante;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante(123456, 987654, "Juan", "Pérez", "2004/04/25", true));

        estudiantes.add(new Estudiante(654321, 456789, "Ana", "Gómez", "2003/02/15", false));

        estudiantes.add(new Estudiante(111222, 333444, "Luis", "Martínez", "2002/08/30", true));

        for (Estudiante estudiante : estudiantes) {

            estudiante.mostrarEstudiante();

        }

    }
}