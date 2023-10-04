package com.github.wikicode96.pedidos.service;

import com.github.wikicode96.pedidos.model.Pedido;
import com.github.wikicode96.pedidos.model.Producto;

import java.util.List;

public interface IPedidoService {

    void addPedido(Pedido pedido);
    List<Pedido> allPedidos();
}
