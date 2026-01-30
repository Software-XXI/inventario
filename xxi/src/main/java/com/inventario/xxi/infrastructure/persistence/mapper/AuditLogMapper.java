package com.inventario.xxi.infrastructure.persistence.mapper;

import com.inventario.xxi.domain.model.ProductAuditLog;
import com.inventario.xxi.infrastructure.persistence.entity.AuditLogEntity;

public class AuditLogMapper {
    public static AuditLogEntity toEntity(ProductAuditLog productAuditLog) {
        if (productAuditLog == null) {
            throw new IllegalArgumentException("AuditLog cannot be null");
        }
        return new AuditLogEntity(
                productAuditLog.getId(),
                productAuditLog.getProductId(),
                productAuditLog.getPreviousStock(),
                productAuditLog.getChangeAmount(),
                productAuditLog.getNewStock(),
                productAuditLog.getTimestamp(),
                productAuditLog.getReason()
        );
    }
}
