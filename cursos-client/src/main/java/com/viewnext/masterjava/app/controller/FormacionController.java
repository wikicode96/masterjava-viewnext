package com.viewnext.masterjava.app.controller;

import com.viewnext.masterjava.app.model.Formacion;
import com.viewnext.masterjava.app.service.IFormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase es un controlador de Spring MVC que maneja las solicitudes relacionadas
 * con la formación, como obtener la lista de cursos y agregar nuevas formaciones.
 */
@RestController
@RequestMapping("/formacion")
public class FormacionController {

    @Autowired
    IFormacionService service;

    /**
     * Obtiene la lista de cursos disponibles.
     *
     * @return Lista de objetos {@link Formacion} que representan los cursos disponibles.
     */
    @GetMapping("/cursos")
    public List<Formacion> obtenerCursos() {
        return service.getCursos();
    }

    /**
     * Registra una nueva formación.
     *
     * @param formacion La formación a ser registrada en el sistema.
     */
    @PostMapping("/alta")
    public void altaFormacion(@RequestBody Formacion formacion) {
        service.altaCurso(formacion);
    }
}
