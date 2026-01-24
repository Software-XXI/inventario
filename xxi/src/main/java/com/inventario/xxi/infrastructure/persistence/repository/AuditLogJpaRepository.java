package com.inventario.xxi.infrastructure.persistence.repository;

import com.inventario.xxi.infrastructure.persistence.entity.AuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogJpaRepository extends JpaRepository<AuditLogEntity, Long> {
}
