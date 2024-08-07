package com.keola.ecommerce_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keola.ecommerce_backend.models.Pedido;
import com.keola.ecommerce_backend.repository.PedidoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Flux<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Mono<Pedido> getPedidoById(String id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public Mono<Pedido> savePedido(Pedido pedido) {
        // Lógica para asegurar consistencia
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Mono<Void> deletePedido(String id) {
        return pedidoRepository.deleteById(id);
    }
}