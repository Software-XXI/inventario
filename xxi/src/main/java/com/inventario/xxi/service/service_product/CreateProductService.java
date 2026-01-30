package com.inventario.xxi.service.service_product;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.product.CreateProductCommand;
import com.inventario.xxi.domain.port.in.product.CreateProductUseCase;
import com.inventario.xxi.domain.port.out.product.ProductRepositoryPort;

public class CreateProductService implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(CreateProductCommand command) {
        Product product = new Product(null, command.name(), command.category(), command.price(),
                command.stock(), command.minStock());
        return productRepositoryPort.save(product);
    }
}
