package com.viewnext.masterjava.app.controller;

import com.viewnext.masterjava.app.model.Curso;
import com.viewnext.masterjava.app.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la gestión de cursos.
 */
@RestController
public class CursoController {

    @Autowired
    ICursoService service;

    /**
     * Obtiene un curso por su identificador.
     *
     * @param id El identificador del curso.
     * @return El curso encontrado o null si no se encuentra.
     */
    @GetMapping(value = "curso/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso(@PathVariable("id") int id){
        return service.getCurso(id);
    }

    /**
     * Obtiene todos los cursos disponibles.
     *
     * @return Una lista de todos los cursos.
     */
    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getAllCursos(){
        return service.getAllCursos();
    }

    /**
     * Guarda un nuevo curso.
     *
     * @param curso El curso a guardar.
     */
    @PostMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> saveCurso(@RequestBody Curso curso){
        return service.saveCurso(curso);
    }

    /**
     * Actualiza un curso existente.
     *
     * @param curso El curso a actualizar.
     */
    @PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCurso(@RequestBody Curso curso){
        service.saveCurso(curso);
    }

    /**
     * Elimina un curso.
     *
     * @param curso El curso a eliminar.
     */
    @DeleteMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCurso(@RequestBody Curso curso){
        service.deleteCurso(curso);
    }

    /**
     * Edita las horas de un curso existente.
     *
     * @param id    El identificador del curso a editar.
     * @param horas Las nuevas horas de duración del curso.
     */
    @PutMapping(value = "curso/{id}/horas/{horas}")
    public void editHorasCurso(@PathVariable("id") int id, @PathVariable("horas") int horas){
        service.editHorasCurso(id, horas);
    }

    /**
     * Obtiene una lista de cursos en un rango de precios específico.
     *
     * @param min El precio mínimo.
     * @param max El precio máximo.
     * @return Una lista de cursos que cumplen con el rango de precios especificado.
     */
    @GetMapping(value = "cursos/precio/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> rangoPrecio(@PathVariable("min") int min, @PathVariable("max") int max){
        return service.rangoPrecio(min, max);
    }
}
