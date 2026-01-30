package com.inventario.xxi.service.service_product;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.product.ListProductsUseCase;
import com.inventario.xxi.domain.port.out.product.ProductRepositoryPort;

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
