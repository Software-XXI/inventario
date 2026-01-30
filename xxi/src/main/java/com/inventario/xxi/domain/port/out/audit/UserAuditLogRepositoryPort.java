package com.inventario.xxi.domain.port.out.audit;

import com.inventario.xxi.domain.model.UserAuditLog;

public interface UserAuditLogRepositoryPort {
    void registerUser(UserAuditLog userAuditLog);
    void loginUser(UserAuditLog userAuditLog);
}
