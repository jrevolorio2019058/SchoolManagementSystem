package main.java.org.example.controller;

import main.java.org.example.exceptions.Excepciones;
import main.java.org.example.model.Curso;
import main.java.org.example.model.Estudiante;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GestorAcademico {

    public static GestorAcademico instancia;
    private List<Estudiante> estudianteList;
    private List<Curso> cursoList;
    private HashMap<Integer, Estudiante> inscripciones;

    Scanner sc = new Scanner(System.in);

    public GestorAcademico() {

        estudianteList = new ArrayList<>();
        cursoList = new ArrayList<>();
        inscripciones = new HashMap<>();

    }

    public static GestorAcademico getInstancia() {

        if(instancia == null) {

            instancia = new GestorAcademico();

        }

        return instancia;

    }

    public void agregarEstudiante(int cui, int carnet, String nombre, String apellido, String fechaDeNacimientoString, String estado) throws ParseException {

        estudianteList.add(new Estudiante(cui, carnet, nombre, apellido, fechaDeNacimientoString, estado));

        System.out.println("El estudiante " + nombre + " " + apellido + " fue agregado");

    }

    public void agregarCurso(String nombre, String descipcion, int numCreditos, String version) throws ParseException {

        int id = cursoList.size() + 1;

        cursoList.add(new Curso(id, nombre, descipcion, numCreditos, version));

        System.out.println("El curso " + nombre + " " + descipcion + " fue agregado");

    }

    public void eliminarEstudiante(int carnet) {

        Estudiante estudianteEliminado = null;

        String nombreEstudiante = null;

        try{

            if(estudianteList.isEmpty()) {

                throw new Excepciones.GestorAcademicoException("NO hay Estudiantes registrados.");

            }else{

                for (Estudiante estudiante : estudianteList) {

                    if (estudiante.getCarnet() == carnet) {

                        estudianteEliminado = estudiante;

                        break;

                    }

                }

                if(estudianteEliminado != null) {

                    nombreEstudiante = estudianteEliminado.getNombre() + " " + estudianteEliminado.getApellido();

                    estudianteList.remove(estudianteEliminado);

                    System.out.println("El estudiante " + nombreEstudiante + " fue eliminado");

                }else {

                    throw new Excepciones.EstadoInvalidoException("Carnet No encontrado.");

                }

            }

        }catch(Excepciones.EstadoInvalidoException | Excepciones.GestorAcademicoException e){

            System.out.println("Error | " + e.getMessage());

        }

    }

    public void editarEstudiante(int carnet){

        try{

            if(estudianteList.isEmpty()) {

                throw new Excepciones.GestorAcademicoException("NO hay Estudiantes registrados.");

            }else{

                for (Estudiante estudiante : estudianteList) {

                    if (estudiante.getCarnet() == carnet) {

                        System.out.println("Estudiante a modificar: " + estudiante.getNombre() + " " + estudiante.getApellido());

                        System.out.println("Que desea actualizar?");

                        System.out.println("1. Nombre");

                        System.out.println("2. Apellido");

                        System.out.println("3. Fecha de nacimiento");

                        System.out.println("4. Edad");

                        System.out.println("5. Estado");

                        int option = sc.nextInt();

                        System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");

                        switch (option) {

                            case 1:

                                System.out.println("Ingrese el nuevo nombre: ");

                                String nombre = sc.next();

                                estudiante.setNombre(nombre);

                                break;

                            case 2:

                                System.out.println("Ingrese el nuevo apellido: ");

                                String apellido = sc.next();

                                estudiante.setApellido(apellido);

                                break;

                            case 3:

                                System.out.println("Ingrese la nueva fecha de nacimiento en el siguiente formato (día/mes/año): ");

                                String fechaDeNacimiento = sc.next();

                                estudiante.setFechaDeNacimiento(fechaDeNacimiento);

                                break;

                            case 4:


                                System.out.println("Ingrese la nueva edad: ");

                                int edad = sc.nextInt();

                                estudiante.setEdad(edad);

                                break;

                            case 5:

                                System.out.println("Ingrese el nuevo estado: ");

                                String estado = sc.next();

                                estudiante.setEstado(estado);

                                break;

                            default:

                                throw new Excepciones.GestorAcademicoException("Opción no valida");
                        }


                    }else {

                        throw new Excepciones.GestorAcademicoException("Carnet No encontrado.");

                    }

                }

            }

        }catch(Excepciones.GestorAcademicoException | ParseException e){

            System.out.println("Error | " + e.getMessage());

        }

    }

    public void mostrarEstudiante(int carnet){

        try{

            for (Estudiante estudiante : estudianteList) {

                if (estudiante.getCarnet() == carnet) {

                    System.out.println("-------------------");

                    estudiante.mostrarEstudiante();

                    break;

                }else {

                    throw new Excepciones.EstadoInvalidoException("Carnet No encontrado.");

                }

            }

        }catch(Excepciones.EstadoInvalidoException e){

            System.out.println("Error | " + e.getMessage());

        }

    }

    public void mostrarEstudiantes(){

        for (Estudiante estudiante : estudianteList) {

            estudiante.mostrarEstudiante();

        }

    }

    public void mostrarCurso(int id){

        try{

            boolean find = false;

            for (Curso curso : cursoList) {

                if (curso.getId() == id) {

                    System.out.println("-------------------");

                    curso.mostrarCurso();

                    find = true;

                    break;

                }

            }

            if(!find){

                throw new Excepciones.EstadoInvalidoException("ID No encontrado.");

            }

        }catch(Excepciones.EstadoInvalidoException e){

            System.out.println("Error | " + e.getMessage());

        }

    }

    public void mostrarCursos(){

        for (Curso curso : cursoList){

            curso.mostrarCurso();

        }

    }

}
