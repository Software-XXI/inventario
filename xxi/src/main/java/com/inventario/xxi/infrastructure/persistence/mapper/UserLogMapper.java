package com.inventario.xxi.infrastructure.persistence.mapper;

import com.inventario.xxi.domain.model.UserAuditLog;
import com.inventario.xxi.infrastructure.persistence.entity.UserAuditLogEntity;

public class UserLogMapper {

    // Dominio → Entidad (para guardar)
    public static UserAuditLogEntity toEntity(UserAuditLog userAuditLog) {
        if (userAuditLog == null) {
            throw new IllegalArgumentException("UserAuditLog cannot be null");
        }
        return new UserAuditLogEntity(
                userAuditLog.getId(),
                userAuditLog.getUserId(),
                userAuditLog.getAction(),
                userAuditLog.getEntityType(),
                userAuditLog.getEntityId(),
                userAuditLog.getCommerceId(),
                userAuditLog.isActive(),
                userAuditLog.getTimestamp()
        );
    }

    // Entidad → Dominio (para leer)
    public static UserAuditLog toDomain(UserAuditLogEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("UserAuditLogEntity cannot be null");
        }
        return UserAuditLog.fromPersistence(
                entity.getId(),
                entity.getUserId(),
                entity.getAction(),
                entity.getEntityType(),
                entity.getEntityId(),
                entity.getCommerceId(),
                entity.isActive(),
                entity.getTimestamp()
        );
    }
}
