package com.viewnext.masterjava.app.service;

import com.viewnext.masterjava.app.model.Formacion;

import java.util.List;

public interface IFormacionService {
    List<Formacion> getCursos();
    void altaCurso(Formacion formacion);
}
