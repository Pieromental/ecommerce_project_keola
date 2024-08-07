package com.keola.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keola.ecommerce_backend.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}