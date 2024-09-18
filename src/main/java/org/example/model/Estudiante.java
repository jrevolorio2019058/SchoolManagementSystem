package main.java.org.example.model;

import main.java.org.example.exceptions.Excepciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Estudiante {

    private static Estudiante estudiante;
    private final int CUI;
    private final int carnet;
    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaDeNacimiento;
    private String estado;

    public Estudiante(int cui, int carnet, String nombre, String apellido, String fechaDeNacimientoString, String estado) throws ParseException {
        this.CUI = cui;
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = convertirStringADate(fechaDeNacimientoString);
        this.edad = calcularEdad(convertirStringADate(fechaDeNacimientoString));

        try {

            validarEstado(estado);

            this.estado = estado.toUpperCase();

        } catch (Excepciones.EstadoInvalidoException e) {

            System.out.println("Error al establecer el estado: " + e.getMessage());

            this.estado = "INACTIVO";

        }

    }

    public static Estudiante getInstancia(int cui, int carnet, String nombre, String apellido, String fechaDeNacimientoString, String estado) throws ParseException {
        if (estudiante == null) {
            estudiante = new Estudiante(cui, carnet, nombre, apellido, fechaDeNacimientoString, estado);
        }
        return estudiante;
    }

    public int getCUI() {
        return CUI;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimientoString) throws ParseException {

        this.fechaDeNacimiento = convertirStringADate(fechaDeNacimientoString);

        this.edad = calcularEdad(convertirStringADate(fechaDeNacimientoString));

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

    public static int calcularEdad(Date fechaDeNacimiento){

        Calendar nacimiento = Calendar.getInstance();

        nacimiento.setTime(fechaDeNacimiento);

        Calendar actual = Calendar.getInstance();

        int respuestaEdad = actual.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);

        if (actual.get(Calendar.MONTH) < nacimiento.get(Calendar.MONTH) ||

                (actual.get(Calendar.MONTH) == nacimiento.get(Calendar.MONTH) &&

                        actual.get(Calendar.DAY_OF_MONTH) < nacimiento.get(Calendar.DAY_OF_MONTH))) {

            respuestaEdad--;

        }

        return respuestaEdad;

    }

    public static Date convertirStringADate(String fechaString) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

        return formato.parse(fechaString);

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

    public void validarEstado (String estado) throws Excepciones.EstadoInvalidoException {

        if (!estado.equalsIgnoreCase("matriculado") &&
                !estado.equalsIgnoreCase("inactivo") &&
                !estado.equalsIgnoreCase("graduado")) {
            throw new Excepciones.EstadoInvalidoException("Estado inválido: " + estado + ". Debe ser 'matriculado', 'inactivo' o 'graduado'. \nNota: El estado por el error pasara a INACTIVO.");
        }

    }

}
