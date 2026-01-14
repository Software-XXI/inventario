package com.inventario.xxi.infrastructure.persistence.adapter;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;
import com.inventario.xxi.infrastructure.persistence.entity.ProductEntity;
import com.inventario.xxi.infrastructure.persistence.repository.ProductJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductJpaRepository productJpaRepository;

    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapToEntity(product);
        ProductEntity savedEntity = productJpaRepository.save(entity);
        return mapToDomain(savedEntity);
    }

    @Override
    public List<Product> findAll(){
        return productJpaRepository.findAll().stream().map(this::mapToDomain).toList();
    }

    private Product mapToDomain(ProductEntity savedEntity) {
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getCategory(),
                savedEntity.getPrice(), savedEntity.getStock(), savedEntity.getMinStock());
    }

    private ProductEntity mapToEntity(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getCategory(), product.getPrice(),
                product.getStock(), product.getMinStock());
    }
}
