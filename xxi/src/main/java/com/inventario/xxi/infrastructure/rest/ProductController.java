package com.inventario.xxi.infrastructure.rest;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.CreateProductCommand;
import com.inventario.xxi.domain.port.in.CreateProductUseCase;
import com.inventario.xxi.infrastructure.rest.dto.CreateProductRequest;
import com.inventario.xxi.infrastructure.rest.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest request){
        CreateProductCommand command = new CreateProductCommand(
                request.getName(),
                request.getCategory(),
                request.getPrice(),
                request.getStock(),
                request.getMinStock()
        );
        Product product = createProductUseCase.createProduct(command);
        return mapToResponse(product);
    }

    private ProductResponse mapToResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getMinStock()
        );
    }
}
