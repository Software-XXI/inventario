package com.inventario.xxi.infrastructure.persistence.adapter;

import com.inventario.xxi.domain.model.ProductAuditLog;
import com.inventario.xxi.domain.model.UserAuditLog;
import com.inventario.xxi.domain.port.out.audit.AuditLogRepositoryPort;
import com.inventario.xxi.infrastructure.persistence.repository.AuditLogJpaRepository;
import com.inventario.xxi.infrastructure.persistence.mapper.AuditLogMapper;
import com.inventario.xxi.infrastructure.persistence.entity.AuditLogEntity;
import org.springframework.stereotype.Component;

@Component
public class AuditLogRepositoryAdapter implements AuditLogRepositoryPort {
    private final AuditLogJpaRepository jpaRepository;

    public AuditLogRepositoryAdapter(AuditLogJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(ProductAuditLog productAuditLog) {
        AuditLogEntity entity = AuditLogMapper.toEntity(productAuditLog);
        jpaRepository.save(entity);
    }
}
