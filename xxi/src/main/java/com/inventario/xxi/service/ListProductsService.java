package com.inventario.xxi.service;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.ListProductsUseCase;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;

import java.util.List;

public class ListProductsService implements ListProductsUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public ListProductsService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<Product> listProducts() {
        return productRepositoryPort.findAll();
    }
}
