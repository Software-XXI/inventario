package com.inventario.xxi.infrastructure.persistence.mapper;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.infrastructure.persistence.entity.ProductEntity;

public class ProductMapper {

    // Dominio → Entidad (para guardar)
    public static ProductEntity toEntity(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return new ProductEntity(
                null,
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getMinStock(),
                0L // Version
                // No se pasa el version porque se deja que JPA lo maneje
        );
    }

    // Nuevo metodo para actualizar productos existentes
    public static ProductEntity toEntity(Product product, Long version) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getMinStock(),
                version  // ← Usar la version actual
        );
    }

    // Entidad → Dominio (para leer)
    public static Product toDomain(ProductEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("ProductEntity cannot be null");
        }
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getPrice(),
                entity.getStock(),
                entity.getMinStock()
        );
    }
}
