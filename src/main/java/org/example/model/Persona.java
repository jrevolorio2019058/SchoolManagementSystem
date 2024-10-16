package main.java.org.example.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaDeNacimiento;

    public Persona(String nombre, String apellido, String fechaDeNacimientoString) throws ParseException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = convertirStringADate(fechaDeNacimientoString);
        this.edad = calcularEdad(this.fechaDeNacimiento);
    }

    // Getters y Setters
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

    public static int calcularEdad(Date fechaDeNacimiento) {
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        return formato.parse(fechaString);
    }
}
