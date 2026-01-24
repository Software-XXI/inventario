package com.inventario.xxi.infrastructure.persistence.adapter;

import com.inventario.xxi.domain.model.AuditLog;
import com.inventario.xxi.domain.port.out.AuditLogRepositoryPort;
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
    public void save(AuditLog auditLog) {
        AuditLogEntity entity = AuditLogMapper.toEntity(auditLog);
        jpaRepository.save(entity);
    }
}
