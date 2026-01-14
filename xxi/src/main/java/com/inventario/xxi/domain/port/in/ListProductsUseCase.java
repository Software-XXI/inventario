package com.inventario.xxi.domain.port.in;

import com.inventario.xxi.domain.model.Product;

import java.util.List;

public interface ListProductsUseCase {
    List<Product> listProducts();
}
