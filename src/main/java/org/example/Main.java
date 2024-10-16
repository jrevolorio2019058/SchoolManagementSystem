package main.java.org.example;

import main.java.org.example.controller.GestorAcademico;
import main.java.org.example.exceptions.Excepciones;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        GestorAcademico ga = GestorAcademico.getInstancia();
        Scanner sc = new Scanner(System.in);
        int respuestaFinal = 0;

        System.out.println(" * * * * * Bienvenido * * * * * ");

        do {
            System.out.println("Ingrese la opción que desee realizar:");
            System.out.println("    1. Crear Curso o Estudiante");
            System.out.println("    2. Modificar Curso o Estudiante");
            System.out.println("    3. Eliminar Curso o Estudiante");
            System.out.println("    4. Listar Información General");
            System.out.println("    5. Gestión Estudiante");
            System.out.println("    6. Salir");

            int opcion = sc.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el modelo que desee agregar:");
                    System.out.println("    1. Estudiante");
                    System.out.println("    2. Curso");

                    int agregar = sc.nextInt();
                    System.out.println("");

                    switch (agregar) {
                        case 1:
                            try {
                                System.out.println("Ingrese CUI: ");
                                BigInteger CUI = sc.nextBigInteger();
                                System.out.println("Ingrese Carnet: ");
                                int carnet = sc.nextInt();
                                System.out.println("Ingrese Nombre: ");
                                sc.nextLine();
                                String nombre = sc.nextLine();
                                System.out.println("Ingrese Apellido: ");
                                String apellido = sc.nextLine();
                                System.out.println("Ingrese Fecha de Nacimiento (dd/MM/yyyy): ");
                                String fechaNacimiento = sc.nextLine();

                                if (fechaNacimiento.length() != 10 ||
                                        fechaNacimiento.charAt(2) != '/' ||
                                        fechaNacimiento.charAt(5) != '/') {
                                    throw new Excepciones.MainException("Formato no válido | Formato a utilizar: día/mes/año");
                                }

                                ga.agregarEstudiante(CUI, carnet, nombre, apellido, fechaNacimiento, "Inhabilitado");
                                ga.mostrarEstudiantes();

                            } catch (Excepciones.MainException e) {
                                System.out.println("Error | " + e.getMessage());
                            }
                            break;

                        case 2:
                            System.out.println("Ingrese nombre del Curso: ");
                            sc.nextLine();
                            String nombreCurso = sc.nextLine();
                            System.out.println("Ingrese descripción del Curso: ");
                            String descripcionCurso = sc.nextLine();
                            System.out.println("Ingrese número de Créditos del Curso: ");
                            int numCreditos = sc.nextInt();
                            System.out.println("Ingrese versión del Curso: ");
                            sc.nextLine();
                            String versionCurso = sc.nextLine();

                            ga.agregarCurso(nombreCurso, descripcionCurso, numCreditos, versionCurso);
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el modelo que desee modificar:");
                    System.out.println("    1. Estudiante");
                    System.out.println("    2. Curso");

                    int modificar = sc.nextInt();
                    System.out.println("");

                    switch (modificar) {
                        case 1:
                            System.out.println("Ingrese el carnet del usuario a modificar:");
                            int carnetModificar = sc.nextInt();
                            ga.editarEstudiante(carnetModificar);
                            break;

                        case 2:
                            System.out.println("Ingrese el ID del curso a modificar: ");
                            int idModificar = sc.nextInt();
                            ga.editarCurso(idModificar);
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el modelo que desee utilizar:");
                    System.out.println("    1. Estudiante");
                    System.out.println("    2. Curso");

                    int eliminar = sc.nextInt();
                    System.out.println("");

                    switch (eliminar) {
                        case 1:
                            System.out.println("Ingrese el carnet del usuario a eliminar:");
                            int carnetEliminar = sc.nextInt();
                            ga.eliminarEstudiante(carnetEliminar);
                            break;

                        case 2:
                            System.out.println("Ingrese el ID del Curso a eliminar:");
                            int idEliminar = sc.nextInt();
                            ga.eliminarCurso(idEliminar);
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el modelo que desee utilizar:");
                    System.out.println("    1. Estudiante");
                    System.out.println("    2. Curso");
                    System.out.println("    3. Alumnos en Cursos");

                    int leer = sc.nextInt();
                    System.out.println("");

                    switch (leer) {
                        case 1:
                            System.out.println("Ingrese lo que desee listar:");
                            System.out.println("    1. Estudiante");
                            System.out.println("    2. Estudiantes");

                            int opcionListar = sc.nextInt();
                            System.out.println("");

                            switch (opcionListar) {
                                case 1:
                                    System.out.println("Ingrese el carnet del usuario a mostrar:");
                                    int carnetMostrar = sc.nextInt();
                                    ga.mostrarEstudiante(carnetMostrar);
                                    break;

                                case 2:
                                    ga.mostrarEstudiantes();
                                    break;

                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            break;

                        case 2:
                            System.out.println("Ingrese lo que desee listar:");
                            System.out.println("    1. Curso");
                            System.out.println("    2. Cursos");

                            int opListar = sc.nextInt();
                            System.out.println("");

                            switch (opListar) {
                                case 1:
                                    System.out.println("Ingrese el ID del curso a listar:");
                                    int idCursoMostrar = sc.nextInt();
                                    ga.mostrarCurso(idCursoMostrar);
                                    break;

                                case 2:
                                    ga.mostrarCursos();
                                    break;

                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            break;

                        case 3:
                            System.out.println("- - - - - - - -");
                            ga.mostrarInscripciones();
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Ingrese la opción que desee realizar: ");
                    System.out.println("    1. Matricular Estudiante");
                    System.out.println("    2. Inhabilitar Estudiante");
                    System.out.println("    3. Inscribir Estudiante en Curso");
                    System.out.println("    4. Desinscribir Estudiante de Curso");

                    int gestionEstudiante = sc.nextInt();

                    switch (gestionEstudiante) {
                        case 1:
                            System.out.println("Ingrese el carnet del estudiante a matricular: ");
                            int carnetMatriculacion = sc.nextInt();
                            ga.matricularEstudiante(carnetMatriculacion);
                            break;

                        case 2:
                            System.out.println("Ingrese el carnet del estudiante a inhabilitar: ");
                            int carnetInhabilitacion = sc.nextInt();
                            ga.inhabilitarEstudiante(carnetInhabilitacion);
                            break;

                        case 3:
                            System.out.println("Ingrese el carnet del estudiante: ");
                            int carnetInscripcion = sc.nextInt();
                            System.out.println("Ingrese el ID del curso: ");
                            int idCursoInscripcion = sc.nextInt();
                            ga.inscribirEstudianteCurso(carnetInscripcion, idCursoInscripcion);
                            break;

                        case 4:
                            System.out.println("Ingrese el carnet del estudiante: ");
                            int carnetDesinscripcion = sc.nextInt();
                            System.out.println("Ingrese el ID del curso: ");
                            int idDesinscripcion = sc.nextInt();
                            ga.desinscribirEstudianteCurso(carnetDesinscripcion, idDesinscripcion);
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("");
            System.out.println("¿Desea realizar otra operación?");
            System.out.println("    1. Sí");
            System.out.println("    2. No");

            int respuesta = sc.nextInt();
            switch (respuesta) {
                case 1:
                    break;
                case 2:
                    respuestaFinal = 1;
                    break;
                default:
                    System.out.println("Respuesta no válida | Cerrando la aplicación.");
                    respuestaFinal = 1;
            }

        } while (respuestaFinal != 1);

        System.out.println(" * * * * * Gracias por tu tiempo * * * * * ");
    }
}