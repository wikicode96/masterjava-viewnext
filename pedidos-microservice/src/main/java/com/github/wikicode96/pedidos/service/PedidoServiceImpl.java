package com.github.wikicode96.pedidos.service;

import com.github.wikicode96.pedidos.model.Pedido;
import com.github.wikicode96.pedidos.model.Producto;
import com.github.wikicode96.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Esta clase implementa la interfaz IPedidoService y proporciona la lógica de negocio para los pedidos.
 */
@Service
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    PedidoRepository repository;

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:8080";

    /**
     * Obtiene todos los pedidos existentes.
     *
     * @return Una lista de objetos Pedido.
     */
    @Override
    public List<Pedido> allPedidos() {
        return repository.findAll();
    }

    /**
     * Agrega un nuevo pedido después de verificar y actualizar el stock del producto relacionado.
     *
     * @param pedido El objeto Pedido que se va a agregar.
     */
    @Override
    public String addPedido(Pedido pedido) {

        boolean transaction = false;

        //Traemos todos loa productos y buscamos el que coindice con la ID del producto de pedido
        Producto[] productos = restTemplate.getForObject(url + "/productos", Producto[].class);
        for (Producto p: productos) {
            if(p.getId() == pedido.getProductoId() && p.getStock() > pedido.getUnidades()){

                // Actualizamos el Stock del producto según las unidades pedidas
                p.setStock(p.getStock() - pedido.getUnidades());
                restTemplate.put(url + "/producto", p);

                // Actualizamos el total del pedido según las unidades solicitadas y el precio del producto
                pedido.setTotal(p.getPrecio() * pedido.getUnidades());

                // Añadimos el nuevo pedido
                pedido.setFecha(LocalDateTime.now());
                repository.save(pedido);

                transaction = true;
            }
        }

        if (transaction == true){
            return "Pedido añadido exitosamente";
        } else {
            return "El producto no existe o no hay suficiente Stock";
        }
    }
}
