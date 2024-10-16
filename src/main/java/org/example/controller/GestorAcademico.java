package main.java.org.example.controller;

import main.java.org.example.exceptions.Excepciones;
import main.java.org.example.interfaces.ServiciosAcademicosI;
import main.java.org.example.model.Curso;
import main.java.org.example.model.Estudiante;

import java.text.ParseException;
import java.util.*;

public class GestorAcademico implements ServiciosAcademicosI {

    public static GestorAcademico instancia;
    private List<Estudiante> estudianteList;
    private List<Curso> cursoList;
    private HashMap<Estudiante, List<Curso>> inscripciones;

    Scanner sc = new Scanner(System.in);

    private GestorAcademico() {

        if(estudianteList == null){

            estudianteList = new ArrayList<>();

        }

        if(cursoList == null){

            cursoList = new ArrayList<>();

        }

        if(inscripciones == null){

            inscripciones = new HashMap<>();

        }

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

    @Override
    public void matricularEstudiante(int carnet) {

        try{

            if(estudianteList.isEmpty()) {

                throw new Excepciones.GestorAcademicoException("NO hay Estudiantes registrados.");

            }else{

                for (Estudiante estudiante : estudianteList) {

                    if (estudiante.getCarnet() == carnet) {

                        estudiante.setEstado("Matriculado");

                        System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + "fue matriculado exitosamente");

                        break;

                    }else {

                        throw new Excepciones.EstadoInvalidoException("Carnet No encontrado.");

                    }

                }

            }

        }catch(Excepciones.EstadoInvalidoException | Excepciones.GestorAcademicoException e){

            System.out.println("Error | " + e.getMessage());

        }

    }

    @Override
    public void agregarCurso(String nombre, String descipcion, int numCreditos, String version){

        int id = cursoList.size() + 1;

        cursoList.add(new Curso(id, nombre, descipcion, numCreditos, version));

        System.out.println("El curso " + nombre + " " + descipcion + " fue agregado");

    }

    public void eliminarEstudiante(int carnet) {

        String nombreEstudiante = null;

        try{

            if(estudianteList.isEmpty()) {

                throw new Excepciones.GestorAcademicoException("NO hay Estudiantes registrados.");

            }else{

                for (Estudiante estudiante : estudianteList) {

                    if (estudiante.getCarnet() == carnet) {

                        nombreEstudiante = estudiante.getNombre() + " " + estudiante.getApellido();

                        estudiante.setEstado("Inactivo");

                        System.out.println("El estudiante " + nombreEstudiante + " fue eliminado");

                        break;

                    }else {

                        throw new Excepciones.EstadoInvalidoException("Carnet No encontrado.");

                    }

                }

            }

        }catch(Excepciones.EstadoInvalidoException | Excepciones.GestorAcademicoException e){

            System.out.println("Error | " + e.getMessage());

        }

    }

    @Override
    public void inhabilitarEstudiante(int carnet) {

        try{

            if(estudianteList.isEmpty()) {

                throw new Excepciones.GestorAcademicoException("NO hay Estudiantes registrados.");

            }else{

                for (Estudiante estudiante : estudianteList) {

                    if (estudiante.getCarnet() == carnet) {

                        estudiante.setEstado("Inhabilitado");

                        System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + "fue matriculado exitosamente");

                        break;

                    }else {

                        throw new Excepciones.EstadoInvalidoException("Carnet No encontrado.");

                    }

                }

            }

        }catch(Excepciones.EstadoInvalidoException | Excepciones.GestorAcademicoException e){

            System.out.println("Error | " + e.getMessage());

        }

    }

    public void eliminarCurso(int id) {

        Curso cursoEliminado = null;

        String nombreCurso = null;

        try{

            if(cursoList.isEmpty()) {

                throw new Excepciones.GestorAcademicoException("NO hay Cursos registrados.");

            }else{

                for (Curso curso : cursoList) {

                    if (curso.getId() == id) {

                        cursoEliminado = curso;

                        break;

                    }

                }

                if(cursoEliminado != null) {

                    nombreCurso = cursoEliminado.getNombre();

                    cursoList.remove(cursoEliminado);

                    System.out.println("El Curso " + nombreCurso + " fue eliminado");

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

    public void editarCurso(int id){

        try{

            if(cursoList.isEmpty()) {

                throw new Excepciones.GestorAcademicoException("NO hay Cursos registrados.");

            }else{

                for (Curso curso : cursoList) {

                    if (curso.getId() == id) {

                        System.out.println("Curso a modificar: " + curso.getNombre());

                        System.out.println("Que desea actualizar?");

                        System.out.println("1. Nombre");

                        System.out.println("2. Descripción");

                        System.out.println("3. Creditos");

                        System.out.println("4. Versión");

                        int option = sc.nextInt();

                        System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");

                        switch (option) {

                            case 1:

                                System.out.println("Ingrese el nuevo nombre: ");

                                sc.nextLine();

                                String nombre = sc.nextLine();

                                curso.setNombre(nombre);

                                break;

                            case 2:

                                System.out.println("Ingrese la nueva descripción: ");

                                sc.nextLine();

                                String descripcion = sc.nextLine();

                                curso.setDescripcion(descripcion);

                                break;

                            case 3:

                                System.out.println("Ingrese el nuevo credito");

                                sc.nextLine();

                                int credito = sc.nextInt();

                                curso.setNumeroCreditos(credito);

                                break;

                            case 4:


                                System.out.println("Ingrese la nueva versión: ");

                                sc.nextLine();

                                String version = sc.nextLine();

                                curso.setVersion(version);

                                break;

                            default:

                                throw new Excepciones.GestorAcademicoException("Opción no valida");
                        }


                    }else {

                        throw new Excepciones.GestorAcademicoException("ID No encontrado.");

                    }

                }

            }

        }catch(Excepciones.GestorAcademicoException e){

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

    @Override
    public void inscribirEstudianteCurso(int carnet, int id) {
        try {
            if (estudianteList.isEmpty()) {
                throw new Excepciones.GestorAcademicoException("NO hay Estudiantes registrados.");
            }

            if (cursoList.isEmpty()) {
                throw new Excepciones.GestorAcademicoException("No hay Cursos registrados.");
            }

            Estudiante estudianteEncontrado = null;
            for (Estudiante estudiante : estudianteList) {
                if (estudiante.getCarnet() == carnet) {
                    estudianteEncontrado = estudiante;
                    break;
                }
            }

            if (estudianteEncontrado == null) {
                throw new Excepciones.EstadoInvalidoException("Carnet No encontrado.");
            }

            Curso cursoEncontrado = null;
            for (Curso curso : cursoList) {
                if (curso.getId() == id) {
                    cursoEncontrado = curso;
                    break;
                }
            }

            if (cursoEncontrado == null) {
                throw new Excepciones.EstadoInvalidoException("Curso No encontrado.");
            }

            List<Curso> cursosInscritos = inscripciones.getOrDefault(estudianteEncontrado, new ArrayList<>());
            boolean yaInscrito = cursosInscritos.stream().anyMatch(c -> c.getId() == id);

            if (yaInscrito) {
                throw new Excepciones.EstudianteYaInscritoException("El estudiante ya está inscrito en el curso.");
            }

            cursosInscritos.add(cursoEncontrado);
            inscripciones.put(estudianteEncontrado, cursosInscritos);

            System.out.println("El estudiante " + estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getApellido() + " ha sido inscrito en el curso " + cursoEncontrado.getNombre());

        } catch (Excepciones.EstudianteYaInscritoException | Excepciones.EstadoInvalidoException | Excepciones.GestorAcademicoException e) {
            System.out.println("Error | " + e.getMessage());
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int carnet, int id) {
        try {
            if (estudianteList.isEmpty()) {
                throw new Excepciones.GestorAcademicoException("NO hay Estudiantes registrados.");
            }

            if (cursoList.isEmpty()) {
                throw new Excepciones.GestorAcademicoException("No hay Cursos registrados.");
            }

            Estudiante estudianteEncontrado = null;
            for (Estudiante estudiante : estudianteList) {
                if (estudiante.getCarnet() == carnet) {
                    estudianteEncontrado = estudiante;
                    break;
                }
            }

            if (estudianteEncontrado == null) {
                throw new Excepciones.EstadoInvalidoException("Carnet No encontrado.");
            }

            Curso cursoEncontrado = null;
            for (Curso curso : cursoList) {
                if (curso.getId() == id) {
                    cursoEncontrado = curso;
                    break;
                }
            }

            if (cursoEncontrado == null) {
                throw new Excepciones.EstadoInvalidoException("Curso No encontrado.");
            }

            List<Curso> cursosInscritos = inscripciones.getOrDefault(estudianteEncontrado, new ArrayList<>());

            boolean yaInscrito = cursosInscritos.stream().anyMatch(c -> c.getId() == id);

            if (!yaInscrito) {

                throw new Excepciones.EstadoInvalidoException("El estudiante no está inscrito en el curso.");

            }

            cursosInscritos.removeIf(c -> c.getId() == id);

            if (cursosInscritos.isEmpty()) {

                inscripciones.remove(estudianteEncontrado);

            } else {

                inscripciones.put(estudianteEncontrado, cursosInscritos);

            }

            System.out.println("El estudiante " + estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getApellido() + " ha sido desinscrito del curso " + cursoEncontrado.getNombre());

        } catch (Excepciones.EstadoInvalidoException | Excepciones.GestorAcademicoException e) {

            System.out.println("Error | " + e.getMessage());

        }
    }

    public void mostrarInscripciones() {
        if (inscripciones.isEmpty()) {
            System.out.println("No hay inscripciones registradas.");
            return;
        }

        for (Map.Entry<Estudiante, List<Curso>> entry : inscripciones.entrySet()) {
            Estudiante estudiante = entry.getKey();
            List<Curso> cursos = entry.getValue();

            System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido() + " (Carnet: " + estudiante.getCarnet() + ")");

            if (cursos.isEmpty()) {
                System.out.println("  No está inscrito en ningún curso.");
            } else {
                System.out.println("  Cursos inscritos:");
                for (Curso curso : cursos) {
                    System.out.println("    - " + curso.getNombre() + " (ID: " + curso.getId() + ")");
                }
            }
        }
    }

}
