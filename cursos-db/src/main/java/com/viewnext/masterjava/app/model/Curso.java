package com.viewnext.masterjava.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa un curso de la DB.
 */
@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String nombre;
    private int duracion;
    private int precio;

    /**
     * Constructor sin argumentos.
     */
    public Curso() {
    }

    /**
     * Constructor con argumentos.
     *
     * @param id       El identificador del curso.
     * @param nombre   El nombre del curso.
     * @param duracion La duración del curso.
     * @param precio   El precio del curso.
     */
    public Curso(int id, String nombre, int duracion, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id == curso.id && duracion == curso.duracion && precio == curso.precio && Objects.equals(nombre, curso.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, duracion, precio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
