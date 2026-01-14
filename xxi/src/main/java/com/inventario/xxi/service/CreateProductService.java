package com.inventario.xxi.service;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.CreateProductCommand;
import com.inventario.xxi.domain.port.in.CreateProductUseCase;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;

public class CreateProductService implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(CreateProductCommand command) {
        Product product = new Product(null, command.getName(), command.getCategory(), command.getPrice(),
                command.getStock(), command.getMinStock());
        return productRepositoryPort.save(product);
    }
}
