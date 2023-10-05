package com.github.wikicode96.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hoteles")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "categoria")
    private int categoria;
    @Column(name = "precio")
    private int precio;
    @Column(name = "disponible")
    private boolean disponible;

    public Hotel() {
    }

    public Hotel(int id, String nombre, int categoria, int precio, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id && categoria == hotel.categoria && precio == hotel.precio && disponible == hotel.disponible && Objects.equals(nombre, hotel.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, categoria, precio, disponible);
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
