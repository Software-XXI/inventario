package com.inventario.xxi.service.service_product;

import com.inventario.xxi.domain.model.ProductAuditLog;
import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.product.UpdateStockUseCase;
import com.inventario.xxi.domain.port.out.audit.AuditLogRepositoryPort;
import com.inventario.xxi.domain.port.out.product.ProductRepositoryPort;
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
        ProductAuditLog log = ProductAuditLog.stockChange(
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
