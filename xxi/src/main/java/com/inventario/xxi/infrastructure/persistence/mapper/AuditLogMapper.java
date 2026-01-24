package com.inventario.xxi.infrastructure.persistence.mapper;

import com.inventario.xxi.domain.model.AuditLog;
import com.inventario.xxi.infrastructure.persistence.entity.AuditLogEntity;

public class AuditLogMapper {
    public static AuditLogEntity toEntity(AuditLog auditLog) {
        if (auditLog == null) {
            throw new IllegalArgumentException("AuditLog cannot be null");
        }
        return new AuditLogEntity(
                auditLog.getId(),
                auditLog.getProductId(),
                auditLog.getPreviousStock(),
                auditLog.getChangeAmount(),
                auditLog.getNewStock(),
                auditLog.getTimestamp(),
                auditLog.getReason()
        );
    }
}
