package com.github.wikicode96.pedidos.controller;

import com.github.wikicode96.pedidos.model.Pedido;
import com.github.wikicode96.pedidos.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase es un controlador Spring MVC que maneja las solicitudes relacionadas con los pedidos.
 * Proporciona endpoints para obtener todos los pedidos y agregar un nuevo pedido.
 */
@RestController
public class PedidoController {

    @Autowired
    IPedidoService service;

    /**
     * Maneja una solicitud GET para obtener todos los pedidos y devuelve una lista de pedidos en formato JSON.
     *
     * @return Una lista de objetos Pedido en formato JSON.
     */
    @GetMapping(value = "pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Pedido> getAllPedidos(){
        return service.allPedidos();
    }

    /**
     * Maneja una solicitud POST para agregar un nuevo pedido.
     *
     * @param pedido El objeto Pedido que se va a agregar.
     */
    @PostMapping(value = "pedido", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addPedido(@RequestBody Pedido pedido){
        service.addPedido(pedido);
    }
}
