package com.inventario.xxi.service;

import com.inventario.xxi.domain.model.AuditLog;
import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.UpdateStockUseCase;
import com.inventario.xxi.domain.port.out.AuditLogRepositoryPort;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;
import jakarta.transaction.Transactional;

public class UpdateStockService  implements UpdateStockUseCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final AuditLogRepositoryPort auditLogRepositoryPort;

    public UpdateStockService(ProductRepositoryPort productRepositoryPort, AuditLogRepositoryPort auditLogRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
        this.auditLogRepositoryPort = auditLogRepositoryPort;
    }

    @Override
    @Transactional
    public void updateStock(Long id, Integer stock) {
        Product product = productRepositoryPort.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        boolean isLowStock = product.isLowStock();
        if(stock > 0){
            product.increaseStock(stock);
        }else{
            product.decreaseStock(Math.abs(stock));
        }
        AuditLog log = AuditLog.stockChange(
                product.getId(),
                product.getStock() - stock,
                stock,
                product.getStock(),
                "Actualización de stock"
        );
        auditLogRepositoryPort.save(log);
        productRepositoryPort.save(product);
    }
}
