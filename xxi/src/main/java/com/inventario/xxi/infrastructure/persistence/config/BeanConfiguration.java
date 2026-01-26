package com.inventario.xxi.infrastructure.persistence.config;

import com.inventario.xxi.domain.port.in.CreateProductUseCase;
import com.inventario.xxi.domain.port.in.DeleteProductUseCase;
import com.inventario.xxi.domain.port.in.ListProductsUseCase;
import com.inventario.xxi.domain.port.in.UpdateStockUseCase;
import com.inventario.xxi.domain.port.out.AuditLogRepositoryPort;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;
import com.inventario.xxi.service.CreateProductService;
import com.inventario.xxi.service.DeleteProductService;
import com.inventario.xxi.service.ListProductsService;
import com.inventario.xxi.service.UpdateStockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepositoryPort productRepositoryPort){
        return new CreateProductService(productRepositoryPort);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase(ProductRepositoryPort productRepositoryPort){
        return new ListProductsService(productRepositoryPort);
    }

    @Bean
    public UpdateStockUseCase updateStockUseCase(ProductRepositoryPort productRepositoryPort, AuditLogRepositoryPort auditLogRepositoryPort){
        return new UpdateStockService(productRepositoryPort, auditLogRepositoryPort);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductRepositoryPort productRepositoryPort){
        return new DeleteProductService(productRepositoryPort);
    }
}
