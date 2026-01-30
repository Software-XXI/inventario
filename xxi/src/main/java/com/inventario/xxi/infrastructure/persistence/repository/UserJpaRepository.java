package com.inventario.xxi.infrastructure.persistence.repository;

import com.inventario.xxi.infrastructure.persistence.entity.ProductEntity;
import com.inventario.xxi.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
