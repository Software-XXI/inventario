package com.inventario.xxi.domain.port.out;

import com.inventario.xxi.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
}
