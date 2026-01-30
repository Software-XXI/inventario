package com.inventario.xxi.domain.model;

import java.time.LocalDateTime;

public class UserAuditLog {
    private Long id;
    private Long userId;
    private String action;
    private String entityType;
    private Long entityId;
    private Long commerceId;
    private boolean active;
    private LocalDateTime timestamp;

    private UserAuditLog(Long id, Long userId, String action, String entityType, Long entityId, Long commerceId, boolean active, LocalDateTime timestamp){
        this.id = id;
        this.userId = userId;
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.commerceId = commerceId;
        this.active = active;
        this.timestamp = timestamp;
    }

    public UserAuditLog(
            Long userId,
            String action,
            String entityType,
            Long entityId,
            Long commerceId,
            boolean active
    ) {
        this.userId = userId;
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.commerceId = commerceId;
        this.active = active;
        this.timestamp = LocalDateTime.now();
    }

    // ✅ FACTORY METHOD PARA INFRAESTRUCTURA (reconstruir desde BD)
    public static UserAuditLog fromPersistence(Long id, Long userId, String action, String entityType, Long entityId, Long commerceId, boolean active, LocalDateTime timestamp) {
        return new UserAuditLog(id, userId, action, entityType, entityId, commerceId, active, timestamp);
    }
    // ✅ FACTORY METHODS PARA DOMINIO (crear nuevos)
    public static UserAuditLog userAction(Long userId, String action, String entityType, Long entityId, Long commerceId) {
        return new UserAuditLog(null, userId, action, entityType, entityId, commerceId, true, LocalDateTime.now());
    }

    public static UserAuditLog userRegistered(Long userId) {
        return new UserAuditLog(null, userId, "REGISTERED", "USER", userId, 0L, true, LocalDateTime.now());
    }

    public static UserAuditLog simpleUserAction(
            Long userId,
            String action
    ) {
        return new UserAuditLog(userId, action, null, null, null, true);
    }

    public static UserAuditLog userLogin(Long userId, Long commerceId){
        return new UserAuditLog(userId, "LOGIN", "USER", userId, commerceId, true);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getEntityType() {
        return entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public Long getCommerceId() {
        return commerceId;
    }

    public boolean isActive() {
        return active;
    }
}
