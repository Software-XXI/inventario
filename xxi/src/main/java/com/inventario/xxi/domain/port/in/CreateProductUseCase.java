package com.inventario.xxi.domain.port.in;

import com.inventario.xxi.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(CreateProductCommand command);
}
