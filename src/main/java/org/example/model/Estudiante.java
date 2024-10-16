package main.java.org.example.model;

import main.java.org.example.exceptions.Excepciones;

import java.math.BigInteger; // Importa BigInteger
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Estudiante extends Persona {
    private static Estudiante estudiante;
    private final BigInteger CUI;
    private final int carnet;
    private String estado;

    public Estudiante(BigInteger cui, int carnet, String nombre, String apellido, String fechaDeNacimientoString, String estado) throws ParseException {
        super(nombre, apellido, fechaDeNacimientoString);
        this.CUI = cui;
        this.carnet = carnet;
        setEstado(estado);
    }

    public static Estudiante getInstancia(BigInteger cui, int carnet, String nombre, String apellido, String fechaDeNacimientoString, String estado) throws ParseException {
        if (estudiante == null) {
            estudiante = new Estudiante(cui, carnet, nombre, apellido, fechaDeNacimientoString, estado);
        }
        return estudiante;
    }

    public BigInteger getCUI() {
        return CUI;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        try {
            validarEstado(estado);
            this.estado = estado.toUpperCase();
        } catch (Excepciones.EstadoInvalidoException e) {
            System.out.println("Error al establecer el estado: " + e.getMessage());
            this.estado = "INACTIVO";
        }
    }

    public void mostrarEstudiante() {
        System.out.println("CUI: " + getCUI());
        System.out.println("Carnet: " + getCarnet());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Edad: " + getEdad());
        System.out.println("Fecha de Nacimiento: " + getFechaDeNacimiento());
        System.out.println("Estado: " + getEstado());
        System.out.println("---------------");
    }

    public void validarEstado(String estado) throws Excepciones.EstadoInvalidoException {
        if (!estado.equalsIgnoreCase("matriculado") &&
                !estado.equalsIgnoreCase("inactivo") &&
                !estado.equalsIgnoreCase("graduado") &&
                !estado.equalsIgnoreCase("inhabilitado")) {
            throw new Excepciones.EstadoInvalidoException("Estado inválido: " + estado + ". Debe ser 'matriculado', 'inhabilitado', 'inactivo' o 'graduado'. \nNota: El estado por el error pasara a INACTIVO.");
        }
    }
}