package com.keola.ecommerce_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.keola.ecommerce_backend.models.Producto;
import com.keola.ecommerce_backend.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://dummyjson.com/products";

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

       public void importProductosFromAPI() {
        ApiResponse response = restTemplate.getForObject(API_URL, ApiResponse.class);
        if (response != null) {
            List<Producto> productos = response.getProducts();
            for (Producto producto : productos) {
                Optional<Producto> existingProducto = productoRepository.findById(producto.getId());
                if (existingProducto.isPresent()) {
                    Producto productoToUpdate = existingProducto.get();
                    productoToUpdate.setTitle(producto.getTitle());
                    productoToUpdate.setDescription(producto.getDescription());
                    productoToUpdate.setCategory(producto.getCategory());
                    productoToUpdate.setPrice(producto.getPrice());
                    productoToUpdate.setBrand(producto.getBrand());
                    productoToUpdate.setSku(producto.getSku());
                    productoToUpdate.setStock(producto.getStock());
                    productoToUpdate.setThumbnail(producto.getThumbnail());
                    productoRepository.save(productoToUpdate);
                } else {
                    productoRepository.save(producto);
                }
            }
        }
    }

    private static class ApiResponse {
        private List<Producto> products;

        public List<Producto> getProducts() {
            return products;
        }
    }
}