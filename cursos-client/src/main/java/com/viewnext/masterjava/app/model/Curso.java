package com.viewnext.masterjava.app.model;

import java.util.Objects;

public class Curso {

    private int id;
    private String nombre;
    private int duracion;
    private int precio;

    public Curso() {
    }

    public Curso(String nombre, int duracion, int precio) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", precio=" + precio +
                '}';
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
