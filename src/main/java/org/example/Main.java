package main.java.org.example;

import main.java.org.example.controller.GestorAcademico;
import main.java.org.example.exceptions.Excepciones;
import main.java.org.example.model.Curso;
import main.java.org.example.model.Estudiante;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        GestorAcademico ga = GestorAcademico.getInstancia();

        Scanner sc = new Scanner(System.in);

        int respuestaFinal = 0;

        System.out.println(" * * * * * Bienvenido * * * * * ");

        do{

            System.out.println("Ingrese la Opción que desee realizar:");

            System.out.println("    1. Agregar");

            System.out.println("    2. Modificar");

            System.out.println("    3. Eliminar");

            System.out.println("    4. Listar");

            System.out.println("    5. Inscribir");

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

                                String nombre = sc.next();

                                System.out.println("Ingrese Apellido: ");

                                String apellido = sc.next();

                                System.out.println("Ingrese Fecha de Nacimiento: ");

                                String fechaNacimiento = sc.next();

                                if(fechaNacimiento.length() != 10 || fechaNacimiento.charAt(2) != '/' || fechaNacimiento.charAt(5) != '/'){

                                    throw new Excepciones.MainException("Formato no Valido | Formato a utilizar: día/mes/año");

                                }

                                System.out.println("Ingrese Estado");

                                String estado = sc.next();

                                ga.agregarEstudiante(CUI, carnet, nombre, apellido, fechaNacimiento, estado);

                                ga.mostrarEstudiantes();

                            }catch(Excepciones.MainException e){

                                System.out.println("Error | " + e.getMessage());

                            }

                            break;

                        case 2:

                            //Agregar Curso

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

                            System.out.println("Ingrese el carnet del usuario a utilizar:");

                            int carnet = sc.nextInt();

                            ga.editarEstudiante(carnet);

                            break;

                        case 2:

                            //Modificar Curso

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

                            //Eliminar Curso

                            break;

                        default:

                            System.out.println("Opción no Valida");

                            break;

                    }

                    break;

                case 4:

                    //Listar

                    break;

                case 5:

                    //Inscribir

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

//Código Extra (Temporal)

/*cursos.add(new Curso(1, "Programación Java", "Curso de introducción a Java", 3, "1.0"));

        cursos.add(new Curso(2, "Desarrollo Web", "Curso sobre HTML, CSS y JavaScript", 4, "1.0"));

        cursos.add(new Curso(3, "Bases de Datos", "Curso de introducción a bases de datos SQL", 3, "1.0"));

        for(Curso curso : cursos) {

            curso.mostrarCurso();

        }*/