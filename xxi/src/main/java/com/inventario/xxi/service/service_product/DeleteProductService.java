package com.inventario.xxi.service.service_product;

import com.inventario.xxi.domain.port.in.product.DeleteProductUseCase;
import com.inventario.xxi.domain.port.out.product.ProductRepositoryPort;

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
