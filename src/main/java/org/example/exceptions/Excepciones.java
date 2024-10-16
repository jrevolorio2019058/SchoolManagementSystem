package main.java.org.example.exceptions;

public class Excepciones {

    public static class EstadoInvalidoException extends Exception {
        public EstadoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class GestorAcademicoException extends Exception {

        public GestorAcademicoException(String mensaje) {

            super(mensaje);

        }

    }

    public static class MainException extends Exception {

        public MainException(String mensaje) {

            super(mensaje);

        }

    }

    public static class EstudianteYaInscritoException extends Exception {

        public EstudianteYaInscritoException(String mensaje) {

            super(mensaje);

        }

    }

    public static class EstudianteNoInscritoEnCursoException extends Exception {

        public EstudianteNoInscritoEnCursoException(String mensaje) {

            super(mensaje);

        }

    }

}
