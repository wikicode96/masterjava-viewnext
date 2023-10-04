package com.viewnext.masterjava.app.service;

import com.viewnext.masterjava.app.model.Curso;

import java.util.List;

public interface ICursoService {
    Curso getCurso(int id);
    List<Curso> getAllCursos();
    List<Curso> saveCurso(Curso curso);
    void editCurso(Curso curso);
    List<Curso> deleteCurso(Curso curso);
    void editHorasCurso(int id, int horas);
    List<Curso> rangoPrecio(int min, int max);
}
