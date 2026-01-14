package com.inventario.xxi.infrastructure.persistence.config;

import com.inventario.xxi.domain.port.in.CreateProductUseCase;
import com.inventario.xxi.domain.port.in.ListProductsUseCase;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;
import com.inventario.xxi.service.CreateProductService;
import com.inventario.xxi.service.ListProductsService;
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
}
