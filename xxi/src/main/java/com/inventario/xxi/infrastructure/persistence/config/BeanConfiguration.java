package com.inventario.xxi.infrastructure.persistence.config;

import com.inventario.xxi.domain.port.in.product.CreateProductUseCase;
import com.inventario.xxi.domain.port.in.product.DeleteProductUseCase;
import com.inventario.xxi.domain.port.in.product.ListProductsUseCase;
import com.inventario.xxi.domain.port.in.product.UpdateStockUseCase;
import com.inventario.xxi.domain.port.in.user.LoginUseCase;
import com.inventario.xxi.domain.port.in.user.RegisterUserUseCase;
import com.inventario.xxi.domain.port.out.audit.AuditLogRepositoryPort;
import com.inventario.xxi.domain.port.out.audit.UserAuditLogRepositoryPort;
import com.inventario.xxi.domain.port.out.product.ProductRepositoryPort;
import com.inventario.xxi.domain.port.out.security.JwtProviderPort;
import com.inventario.xxi.domain.port.out.user.PasswordEncoderPort;
import com.inventario.xxi.domain.port.out.user.UserRepositoryPort;
import com.inventario.xxi.service.service_product.CreateProductService;
import com.inventario.xxi.service.service_product.DeleteProductService;
import com.inventario.xxi.service.service_product.ListProductsService;
import com.inventario.xxi.service.service_product.UpdateStockService;
import com.inventario.xxi.service.service_user.LoginUserService;
import com.inventario.xxi.service.service_user.RegisterUserService;
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

    @Bean
    public RegisterUserUseCase registerUserUseCase(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort, UserAuditLogRepositoryPort userAuditLogRepositoryPort){
        return new RegisterUserService(userRepositoryPort, passwordEncoderPort, userAuditLogRepositoryPort);
    }

    @Bean
    public LoginUseCase loginUseCase(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort, JwtProviderPort jwtProviderPort, UserAuditLogRepositoryPort userAuditLogRepositoryPort){
        return new LoginUserService(userRepositoryPort, passwordEncoderPort, jwtProviderPort, userAuditLogRepositoryPort);
    }
}
