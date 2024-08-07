package com.keola.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keola.ecommerce_backend.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}