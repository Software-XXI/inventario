package com.inventario.xxi.infrastructure.persistence.config;

import com.inventario.xxi.domain.port.in.CreateProductUseCase;
import com.inventario.xxi.domain.port.out.ProductRepositoryPort;
import com.inventario.xxi.service.CreateProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepositoryPort productRepositoryPort){
        return new CreateProductService(productRepositoryPort);
    }
}
