package main.java.org.example.model;

public class Curso {

    private static Curso curso;
    private final int id;
    private String nombre;
    private String descripcion;
    private int numeroCreditos;
    private String version;

    public Curso(int id, String nombre, String descripcion, int numeroCreditos, String version) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numeroCreditos = numeroCreditos;
        this.version = version;
    }

    public static Curso getCurso(int id, String nombre, String descripcion, int numeroCreditos, String version) {

        if(curso == null) {

            curso = new Curso(id, nombre, descripcion, numeroCreditos, version);

        }

        return curso;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void mostrarCurso() {

        System.out.println("ID: " + getId());

        System.out.println("Nombre: " + getNombre());

        System.out.println("Descripcion: " + getDescripcion());

        System.out.println("Numero Creditos: " + getNumeroCreditos());

        System.out.println("Version: " + getVersion());

        System.out.println("---------------");
    }

}
