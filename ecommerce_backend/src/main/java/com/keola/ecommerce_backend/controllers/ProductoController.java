package com.keola.ecommerce_backend.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.keola.ecommerce_backend.models.Producto;

import com.keola.ecommerce_backend.service.ProductoService;
import com.keola.ecommerce_backend.utils.CustomResponse;
import com.keola.ecommerce_backend.utils.ResponseUtil;

@RestController
@RequestMapping("/api/productos")
public class ProductoController{
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ResponseUtil responseUtil;

    @GetMapping
    public ResponseEntity<?> getAllProductos() {
        try {
            List<Producto> productos = productoService.getAllProductos();
            return responseUtil.createResponse(200, "Success", "Productos retrieved successfully", productos, null, null, "getAllProductos");
        } catch (Exception e) {
            return responseUtil.createResponse(500, "Error", "Error retrieving productos", null, null, e.getMessage(), "getAllProductos");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Long id) {
        try {
            Producto producto = productoService.getProductoById(id);
            return responseUtil.createResponse(200, "Success", "Producto retrieved successfully", producto, null, null, "getProductoById");
        } catch (Exception e) {
            return responseUtil.createResponse(500, "Error", "Error retrieving producto", null, null, e.getMessage(), "getProductoById");
        }
    }

    @PostMapping
    public ResponseEntity<?> saveProducto(@RequestBody Producto producto) {
        try {
            Producto savedProducto = productoService.saveProducto(producto);
            return responseUtil.createResponse(201, "Success", "Producto saved successfully", savedProducto, null, null, "saveProducto");
        } catch (Exception e) {
            return responseUtil.createResponse(500, "Error", "Error saving producto", null, null, e.getMessage(), "saveProducto");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id) {
        try {
            productoService.deleteProducto(id);
            return responseUtil.createResponse(200, "Success", "Producto deleted successfully", null, null, null, "deleteProducto");
        } catch (Exception e) {
            return responseUtil.createResponse(500, "Error", "Error deleting producto", null, null, e.getMessage(), "deleteProducto");
        }
    }

    @PostMapping("/import")
    public ResponseEntity<?> importProductosFromAPI() {
        try {
            productoService.importProductosFromAPI();
            return responseUtil.createResponse(200, "Success", "Productos imported successfully", null, null, null, "importProductosFromAPI");
        } catch (Exception e) {
            return responseUtil.createResponse(500, "Error", "Error importing productos", null, null, e.getMessage(), "importProductosFromAPI");
        }
    }


    @GetMapping("/test-error")
    public ResponseEntity<CustomResponse<String>> testError() {
        try {
            // Simula un error
            throw new RuntimeException("Test error");
        } catch (Exception e) {
            return responseUtil.createResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Error",
                "A test error occurred",
                null,
                null,
                e.getMessage(),
                "testError"
            );
        }
    }
}