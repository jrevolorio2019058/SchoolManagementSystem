package main.java.org.example.model;

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
    private Boolean estado;

    public Estudiante(int cui, int carnet, String nombre, String apellido, String fechaDeNacimientoString, Boolean estado) throws ParseException {
        this.CUI = cui;
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = convertirStringADate(fechaDeNacimientoString);
        this.edad = calcularEdad(convertirStringADate(fechaDeNacimientoString));
        this.estado = estado;
    }

    public static Estudiante getInstancia(int cui, int carnet, String nombre, String apellido, String fechaDeNacimientoString, Boolean estado) throws ParseException {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

        //Explicación: Esto es un if anidado que si el estado es "True" entonces devolvera el Texto "Activo" por lo contrario si es "Falso" devuelve "Inactivo",

        System.out.println("Estado: " + (getEstado() ? "Activo" : "Inactivo"));

        System.out.println("---------------");
    }

}
