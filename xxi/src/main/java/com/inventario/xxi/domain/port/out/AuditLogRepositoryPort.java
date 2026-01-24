package com.inventario.xxi.domain.port.out;

import com.inventario.xxi.domain.model.AuditLog;

public interface AuditLogRepositoryPort {
    void save(AuditLog auditLog);
}
