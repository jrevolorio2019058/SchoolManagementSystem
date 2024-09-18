package main.java.org.example.exceptions;

public class Excepciones {

    public static class EstadoInvalidoException extends Exception {
        public EstadoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

}
