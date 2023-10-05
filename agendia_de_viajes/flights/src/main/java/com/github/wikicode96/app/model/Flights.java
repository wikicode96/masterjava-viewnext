package com.github.wikicode96.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "vuelos")
public class Flights implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "compañia")
    private String compañia;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "precio")
    private int precio;
    @Column(name = "plazas")
    private int plazas;

    public Flights() {
    }

    public Flights(int id, String compañia, Date fecha, int precio, int plazas) {
        this.id = id;
        this.compañia = compañia;
        this.fecha = fecha;
        this.precio = precio;
        this.plazas = plazas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
}
