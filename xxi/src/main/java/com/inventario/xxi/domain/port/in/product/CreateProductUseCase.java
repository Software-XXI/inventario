package com.inventario.xxi.domain.port.in.product;

import com.inventario.xxi.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(CreateProductCommand command);
}
