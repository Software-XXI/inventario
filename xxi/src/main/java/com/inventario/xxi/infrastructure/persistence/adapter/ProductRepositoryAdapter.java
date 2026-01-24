package com.inventario.xxi.infrastructure.persistence.adapter;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;
import com.inventario.xxi.infrastructure.persistence.entity.ProductEntity;
import com.inventario.xxi.infrastructure.persistence.mapper.ProductMapper;
import com.inventario.xxi.infrastructure.persistence.repository.ProductJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductJpaRepository productJpaRepository;

    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity;
        if (product.getId() == null){
            entity = ProductMapper.toEntity(product);
        }
        else{
            ProductEntity existingEntity = productJpaRepository.findById(product.getId()).orElseThrow();
            entity = ProductMapper.toEntity(product, existingEntity.getVersion());
        }
        ProductEntity savedEntity = productJpaRepository.save(entity);
        return ProductMapper.toDomain(savedEntity);
    }

    @Override
    public List<Product> findAll(){
        return productJpaRepository.findAll().stream().map(ProductMapper::toDomain).toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id).map(ProductMapper::toDomain);
    }
}
