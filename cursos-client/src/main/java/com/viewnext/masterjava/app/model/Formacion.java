package com.viewnext.masterjava.app.model;

import java.util.Objects;

public class Formacion {

    private String nombreCurso;
    private int asignaturas;
    private int precio;

    public Formacion() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formacion formacion = (Formacion) o;
        return asignaturas == formacion.asignaturas && Float.compare(precio, formacion.precio) == 0 && Objects.equals(nombreCurso, formacion.nombreCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCurso, asignaturas, precio);
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
