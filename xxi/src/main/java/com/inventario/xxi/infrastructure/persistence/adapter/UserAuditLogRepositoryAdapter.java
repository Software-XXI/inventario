package com.inventario.xxi.infrastructure.persistence.adapter;

import com.inventario.xxi.domain.model.UserAuditLog;
import com.inventario.xxi.domain.port.out.audit.UserAuditLogRepositoryPort;
import com.inventario.xxi.infrastructure.persistence.entity.UserAuditLogEntity;
import com.inventario.xxi.infrastructure.persistence.mapper.UserLogMapper;
import com.inventario.xxi.infrastructure.persistence.repository.UserAuditLogRepository;
import org.springframework.stereotype.Component;

@Component
public class UserAuditLogRepositoryAdapter implements UserAuditLogRepositoryPort {
    private final UserAuditLogRepository userAuditLogRepository;

    public UserAuditLogRepositoryAdapter(UserAuditLogRepository userAuditLogRepository) {
        this.userAuditLogRepository = userAuditLogRepository;
    }

    @Override
    public void registerUser(UserAuditLog userAuditLog) {
        UserAuditLogEntity entity = UserLogMapper.toEntity(userAuditLog);
        userAuditLogRepository.save(entity);
    }

    @Override
    public void loginUser(UserAuditLog userAuditLog) {
        UserAuditLogEntity entity = UserLogMapper.toEntity(userAuditLog);
        userAuditLogRepository.save(entity);
    }
}
