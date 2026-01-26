package com.inventario.xxi.service;

import com.inventario.xxi.domain.port.in.DeleteProductUseCase;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;

public class DeleteProductService implements DeleteProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepositoryPort.deleteById(id);
    }
}
