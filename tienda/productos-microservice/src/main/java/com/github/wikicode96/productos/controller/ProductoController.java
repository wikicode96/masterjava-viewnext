package com.github.wikicode96.productos.controller;

import com.github.wikicode96.productos.model.Producto;
import com.github.wikicode96.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las solicitudes relacionadas con productos.
 */
@RestController
public class ProductoController {

    @Autowired
    IProductoService service;

    /**
     * Obtiene todos los productos y devuelve una lista en formato JSON.
     *
     * @return Lista de objetos Producto en formato JSON.
     */
    @GetMapping(value = "productos", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Producto> getAllProductos(){
        return service.getAllProductos();
    }

    /**
     * Actualiza el stock de un producto mediante una solicitud PUT con un objeto JSON.
     *
     * @param producto El objeto Producto con la información actualizada del stock.
     */
    @PutMapping(value = "producto", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateStock(@RequestBody Producto producto){
        service.updateStock(producto);
    }

    /**
     * Obtiene el precio de un producto por su ID.
     *
     * @param id El ID del producto del cual se desea obtener el precio.
     * @return El precio del producto identificado por el ID proporcionado.
     */
    @GetMapping(value = "producto/price/{id}")
    double getPrecio(@PathVariable("id") int id){
        return service.getPrice(id);
    }
}
