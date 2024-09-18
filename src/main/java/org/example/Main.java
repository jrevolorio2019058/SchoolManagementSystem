package main.java.org.example;

import main.java.org.example.model.Estudiante;

import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        Estudiante estudiante = new Estudiante(123456, 987654, "Juan", "Pérez", "2004/4/25", true);

        System.out.println("CUI: " + estudiante.getCUI());
        System.out.println("Carnet: " + estudiante.getCarnet());
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Apellido: " + estudiante.getApellido());
        System.out.println("Edad: " + estudiante.getEdad());
        System.out.println("Fecha de Nacimiento: " + estudiante.getFechaDeNacimiento());
        System.out.println("Estado: " + (estudiante.getEstado() ? "Activo" : "Inactivo"));

    }
}