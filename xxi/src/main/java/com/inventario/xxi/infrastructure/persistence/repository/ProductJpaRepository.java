package com.inventario.xxi.infrastructure.persistence.repository;

import com.inventario.xxi.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
