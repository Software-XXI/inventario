package com.inventario.xxi.domain.port.out.audit;

import com.inventario.xxi.domain.model.ProductAuditLog;
import com.inventario.xxi.domain.model.UserAuditLog;

public interface AuditLogRepositoryPort {
    void save(ProductAuditLog productAuditLog);
}
