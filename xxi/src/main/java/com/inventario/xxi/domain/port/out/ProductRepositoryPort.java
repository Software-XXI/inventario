package com.inventario.xxi.domain.port.out;

import com.inventario.xxi.domain.model.Product;

import java.util.List;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
}
