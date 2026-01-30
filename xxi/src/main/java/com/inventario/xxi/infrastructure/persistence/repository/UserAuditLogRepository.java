package com.inventario.xxi.infrastructure.persistence.repository;

import com.inventario.xxi.infrastructure.persistence.entity.UserAuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuditLogRepository extends JpaRepository<UserAuditLogEntity, Long> {
}
