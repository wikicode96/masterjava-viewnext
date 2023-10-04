package com.viewnext.masterjava.app.service;

import com.viewnext.masterjava.app.model.Curso;
import com.viewnext.masterjava.app.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz ICursoService que gestiona operaciones relacionadas con cursos.
 */
@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    CursoRepository repository;

    /**
     * Obtiene un curso por su identificador.
     *
     * @param id El identificador del curso.
     * @return El curso encontrado o null si no se encuentra.
     */
    @Override
    public Curso getCurso(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Obtiene todos los cursos disponibles.
     *
     * @return Una lista de todos los cursos.
     */
    @Override
    public List<Curso> getAllCursos() {
        return repository.findAll();
    }

    /**
     * Guarda un curso en la base de datos.
     *
     * @param curso El curso a guardar.
     * @return Una lista de todos los cursos después de la inserción.
     */
    @Override
    public List<Curso> saveCurso(Curso curso) {
        repository.save(curso);
        return repository.findAll();
    }

    /**
     * Edita un curso existente.
     *
     * @param curso El curso a actualizar.
     */
    @Override
    public void editCurso(Curso curso) {
        if(curso.getId() != 0) repository.save(curso);
    }

    /**
     * Elimina un curso.
     *
     * @param curso El curso a eliminar.
     * @return Una lista de todos los cursos después de la eliminación.
     */
    @Override
    public List<Curso> deleteCurso(Curso curso) {
        repository.delete(curso);
        return repository.findAll();
    }

    /**
     * Edita las horas de un curso existente.
     *
     * @param id    El identificador del curso a editar.
     * @param horas Las nuevas horas de duración del curso.
     */
    @Override
    public void editHorasCurso(int id, int horas) {
        Curso curso = repository.findById(id).orElse(null);
        curso.setDuracion(horas);
        repository.save(curso);
    }

    /**
     * Obtiene una lista de cursos en un rango de precios específico.
     *
     * @param min El precio mínimo.
     * @param max El precio máximo.
     * @return Una lista de cursos que cumplen con el rango de precios especificado.
     */
    @Override
    public List<Curso> rangoPrecio(int min, int max) {
        return repository.findByPrecioRange(min, max);
    }
}
