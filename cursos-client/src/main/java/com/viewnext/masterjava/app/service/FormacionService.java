package com.viewnext.masterjava.app.service;

import com.viewnext.masterjava.app.model.Curso;
import com.viewnext.masterjava.app.model.Formacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es un servicio que proporciona operaciones relacionadas con la formación,
 * como obtener la lista de cursos y agregar nuevas formaciones.
 */
@Service
public class FormacionService implements IFormacionService {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:8080";

    /**
     * Obtiene la lista de cursos disponibles desde una fuente remota.
     *
     * @return Lista de objetos {@link Formacion} que representan los cursos disponibles.
     */
    @Override
    public List<Formacion> getCursos() {
        Curso[] cursos = restTemplate.getForObject(url + "/cursos", Curso[].class);
        List<Formacion> formaciones = new ArrayList<>();
        
        for (Curso c: cursos) {
            Formacion formacion = new Formacion();
            formacion.setNombreCurso(c.getNombre());
            formacion.setPrecio(c.getPrecio());

            if(c.getDuracion() >= 50) formacion.setAsignaturas(10);
            else formacion.setAsignaturas(5);

            formaciones.add(formacion);
        }
        return formaciones;
    }

    /**
     * Registra un nuevo curso en una fuente remota si el nombre del curso no existe ya.
     *
     * @param formacion La formación a ser registrada en la fuente remota.
     */
    @Override
    public void altaCurso(Formacion formacion) {

        Curso[] cursos = restTemplate.getForObject(url + "/cursos", Curso[].class);
        boolean nombreEquals = false;

        for (Curso c: cursos){
            if (c.getNombre().equals(formacion.getNombreCurso())) nombreEquals = true;
        }
        if (nombreEquals == false){
            String nombre = formacion.getNombreCurso();
            int duracion = formacion.getAsignaturas() * 10;
            int precio = formacion.getPrecio();

            Curso curso = new Curso(nombre, duracion, precio);
            restTemplate.postForObject(url + "/curso", curso, Curso[].class);
        }
    }
}
