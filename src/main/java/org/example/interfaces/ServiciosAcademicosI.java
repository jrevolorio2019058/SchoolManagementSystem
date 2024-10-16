package main.java.org.example.interfaces;

import main.java.org.example.model.Curso;
import main.java.org.example.model.Estudiante;

import java.text.ParseException;

public interface ServiciosAcademicosI {

    void matricularEstudiante(int carnet);

    void inhabilitarEstudiante(int carnet);

    void agregarCurso(String nombre, String descipcion, int numCreditos, String version) throws ParseException;

    void inscribirEstudianteCurso(int carnet, int id);

    void desinscribirEstudianteCurso(int carnet, int id);

}
