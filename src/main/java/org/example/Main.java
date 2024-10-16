package main.java.org.example;

import main.java.org.example.controller.GestorAcademico;
import main.java.org.example.exceptions.Excepciones;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        GestorAcademico ga = GestorAcademico.getInstancia();

        Scanner sc = new Scanner(System.in);

        int respuestaFinal = 0;

        System.out.println(" * * * * * Bienvenido * * * * * ");

        do{

            System.out.println("Ingrese la Opción que desee realizar:");

            System.out.println("    1. Crear Curso o Estudiante");

            System.out.println("    2. Modificar Curso o Estudiante");

            System.out.println("    3. Eliminar Curso o Estudiante");

            System.out.println("    4. Listar Curso o Estudiante");

            System.out.println("    5. Gestión Estudiante");

            System.out.println("    6. Salir");

            int opcion = sc.nextInt();

            System.out.println("");

            switch(opcion){

                case 1:

                    System.out.println("Ingrese el modelo que desee agregar:");

                    System.out.println("    1. Estudiante");

                    System.out.println("    2. Curso");

                    int agregar = sc.nextInt();

                    System.out.println("");

                    switch(agregar){

                        case 1:

                            try{

                                System.out.println("Ingrese CUI: ");

                                int CUI = sc.nextInt();

                                System.out.println("Ingrese Carnet: ");

                                int carnet = sc.nextInt();

                                System.out.println("Ingrese Nombre: ");

                                sc.nextLine();

                                String nombre = sc.nextLine();

                                System.out.println("Ingrese Apellido: ");

                                String apellido = sc.nextLine();

                                System.out.println("Ingrese Fecha de Nacimiento: ");

                                String fechaNacimiento = sc.nextLine();

                                if(fechaNacimiento.length() != 10 || fechaNacimiento.charAt(2) != '/' || fechaNacimiento.charAt(5) != '/'){

                                    throw new Excepciones.MainException("Formato no Valido | Formato a utilizar: día/mes/año");

                                }

                                ga.agregarEstudiante(CUI, carnet, nombre, apellido, fechaNacimiento, "Inhabilitado");

                                ga.mostrarEstudiantes();

                            }catch(Excepciones.MainException e){

                                System.out.println("Error | " + e.getMessage());

                            }

                            break;

                        case 2:

                            System.out.println("Ingrese nombre del Curso: ");

                            sc.nextLine();

                            String nombreCurso = sc.nextLine();

                            System.out.println("Ingrese descripción del Curso: ");

                            String descripcionCurso = sc.nextLine();

                            System.out.println("Ingrese numero de Creditos del Curso: ");

                            int numCreditos = sc.nextInt();

                            System.out.println("Ingrese versión del Curso: ");

                            sc.nextLine();

                            String versionCurso = sc.nextLine();

                            ga.agregarCurso(nombreCurso, descripcionCurso, numCreditos, versionCurso);

                            break;

                        default:

                            System.out.println("Opción no Valida");

                            break;

                    }

                    break;

                case 2:

                    System.out.println("Ingrese el modelo que desee modificar:");

                    System.out.println("    1. Estudiante");

                    System.out.println("    2. Curso");

                    int modificar = sc.nextInt();

                    System.out.println("");

                    switch(modificar){

                        case 1:

                            System.out.println("Ingrese el carnet del usuario a modificar:");

                            int carnet = sc.nextInt();

                            ga.editarEstudiante(carnet);

                            break;

                        case 2:

                            System.out.println("Ingrese el ID del curso a modificar: ");

                            int id = sc.nextInt();

                            ga.editarCurso(id);

                            break;

                        default:

                            System.out.println("Opción no Valida");

                            break;

                    }

                    break;

                case 3:

                    System.out.println("Ingrese el modelo que desee utilizar:");

                    System.out.println("    1. Estudiante");

                    System.out.println("    2. Curso");

                    int eliminar = sc.nextInt();

                    System.out.println("");

                    switch(eliminar){

                        case 1:

                            System.out.println("Ingrese el carnet del usuario a eliminar:");

                            int carnet = sc.nextInt();

                            ga.eliminarEstudiante(carnet);

                            break;

                        case 2:

                            System.out.println("Ingrese el id del Curso a eliminar:");

                            int id = sc.nextInt();

                            ga.eliminarCurso(id);

                            break;

                        default:

                            System.out.println("Opción no Valida");

                            break;

                    }

                    break;

                case 4:

                    System.out.println("Ingrese el modelo que desee utilizar:");

                    System.out.println("    1. Estudiante");

                    System.out.println("    2. Curso");

                    int leer = sc.nextInt();

                    System.out.println("");

                    switch(leer){

                        case 1:

                            System.out.println("Ingrese lo que desee listar:");

                            System.out.println("    1. Estudiante");

                            System.out.println("    2. Estudiantes");

                            int opcionListar = sc.nextInt();

                            System.out.println("");

                            switch(opcionListar){

                                case 1:

                                    System.out.println("Ingrese el carnet del usuario a mostrar:");

                                    int carnet = sc.nextInt();

                                    ga.mostrarEstudiante(carnet);

                                    break;

                                case 2:

                                    ga.mostrarEstudiantes();

                                    break;

                                default:

                                    System.out.println("Opción no Valida.");

                                    break;

                            }

                            break;

                        case 2:

                            System.out.println("Ingrese lo que desee listar:");

                            System.out.println("    1. Curso");

                            System.out.println("    2. Cursos");

                            int opListar = sc.nextInt();

                            System.out.println("");

                            switch(opListar){

                                case 1:

                                    System.out.println("Ingrese el id del curso a listar:");

                                    int id = sc.nextInt();

                                    ga.mostrarCurso(id);

                                    break;

                                case 2:

                                    ga.mostrarCursos();

                                    break;

                                default:

                                    System.out.println("Opción no Valida.");

                                    break;

                            }

                            break;

                        default:

                            System.out.println("Opción no Valida");

                            break;

                    }

                    break;

                case 5:

                    System.out.println("Ingrese la opción que desee realizar: ");

                    System.out.println("1. Matricular Estudiante");

                    System.out.println("2. Inhabilitar Estudiante");

                    int gestionEstudiante = sc.nextInt();

                    switch(gestionEstudiante){

                        case 1:

                            System.out.println("Ingrese el carnet del estudiante a matricular: ");

                            int carnetMatriculacion = sc.nextInt();

                            ga.matricularEstudiante(carnetMatriculacion);

                            break;

                        case 2:

                            System.out.println("Ingrese el carnet del estudiante a matricular: ");

                            int carnetInhabilitacion = sc.nextInt();

                            ga.inhabilitarEstudiante(carnetInhabilitacion);

                            break;

                        default:

                            break;

                    }

                    break;

                case 6:

                    System.exit(0);

                    break;

                default:

                    System.out.println("Opción no Valida.");

                    break;

            }

            System.out.println("");

            System.out.println(" Desea realizar otra operación?");

            System.out.println("    1. Si");

            System.out.println("    2. No");

            int respuesta = sc.nextInt();

            switch(respuesta){

                case 1:

                    break;

                case 2:

                    respuestaFinal = 1;

                    break;

                default:

                    System.out.println("Respuesta No Valida | Cerrando App.");

                    respuestaFinal = 1;

            }

        }while(respuestaFinal != 1);

        System.out.println(" * * * * * Gracías Por tu tiempo * * * * * ");

    }
}