package com.keola.ecommerce_backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.keola.ecommerce_backend.config.BaseController;
import com.keola.ecommerce_backend.models.Producto;
import com.keola.ecommerce_backend.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController extends BaseController{
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto saveProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }

    @PostMapping("/import")
    public void importProductosFromAPI() {
        productoService.importProductosFromAPI();
    }
}