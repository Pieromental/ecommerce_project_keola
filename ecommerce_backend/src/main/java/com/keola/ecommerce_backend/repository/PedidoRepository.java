package com.keola.ecommerce_backend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.keola.ecommerce_backend.models.Pedido;

@Repository
public interface PedidoRepository extends ReactiveMongoRepository<Pedido, String> {
}