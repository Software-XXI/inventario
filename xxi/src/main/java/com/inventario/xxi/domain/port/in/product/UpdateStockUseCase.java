package com.inventario.xxi.domain.port.in.product;

public interface UpdateStockUseCase {
    void updateStock(Long id, Integer stock);
}
