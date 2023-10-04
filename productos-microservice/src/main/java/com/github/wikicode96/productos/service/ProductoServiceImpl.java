package com.github.wikicode96.productos.service;

import com.github.wikicode96.productos.model.Producto;
import com.github.wikicode96.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz IProductoService que proporciona métodos para interactuar con productos.
 */
@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    ProductoRepository repository;

    /**
     * Obtiene todos los productos disponibles.
     *
     * @return Lista de objetos Producto que representan todos los productos en la base de datos.
     */
    @Override
    public List<Producto> getAllProductos() {
        return repository.findAll();
    }

    /**
     * Actualiza el stock de un producto existente en la base de datos.
     *
     * @param producto El objeto Producto con la información actualizada del stock.
     */
    @Override
    public void updateStock(Producto producto) {
        if(producto.getId() != 0){
            Producto p = repository.findById(producto.getId()).orElse(null);
            if(p != null){
                p.setStock(producto.getStock());
                repository.save(p);
            }
        }
    }

    /**
     * Obtiene el precio de un producto por su ID.
     *
     * @param id El ID del producto del cual se desea obtener el precio.
     * @return El precio del producto identificado por el ID proporcionado.
     */
    @Override
    public double getPrice(int id) {
        Producto producto = repository.findById(id).orElse(null);
        return producto.getPrecio();
    }
}
