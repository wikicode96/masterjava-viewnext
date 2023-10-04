package com.github.wikicode96.pedidos.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private int id;
    @Column(name = "producto_id")
    private int productoId;
    private int unidades;
    private double total;
    private LocalDateTime fecha;

    public Pedido() {
    }

    public Pedido(int id, int productoId, int unidades, double total, LocalDateTime fecha) {
        this.id = id;
        this.productoId = productoId;
        this.unidades = unidades;
        this.total = total;
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id && productoId == pedido.productoId && unidades == pedido.unidades && Double.compare(total, pedido.total) == 0 && Objects.equals(fecha, pedido.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productoId, unidades, total, fecha);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
