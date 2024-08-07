package com.keola.ecommerce_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.keola.ecommerce_backend.config.BaseController;
import com.keola.ecommerce_backend.models.Pedido;
import com.keola.ecommerce_backend.service.PedidoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController extends BaseController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public Flux<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Mono<Pedido> getPedidoById(@PathVariable String id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Mono<Pedido> savePedido(@RequestBody Pedido pedido) {
        return pedidoService.savePedido(pedido);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePedido(@PathVariable String id) {
        return pedidoService.deletePedido(id);
    }
}