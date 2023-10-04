package com.github.wikicode96.pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

public class Producto {

    private int id;
    private String producto;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(int id, String producto, double precio, int stock) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto1 = (Producto) o;
        return id == producto1.id && Double.compare(precio, producto1.precio) == 0 && stock == producto1.stock && Objects.equals(producto, producto1.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producto, precio, stock);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
