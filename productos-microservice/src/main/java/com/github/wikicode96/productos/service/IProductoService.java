package com.github.wikicode96.productos.service;

import com.github.wikicode96.productos.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> getAllProductos();
    void updateStock(Producto producto);
    double getPrice(int id);
}
