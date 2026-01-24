package com.inventario.xxi.infrastructure.rest;

import com.inventario.xxi.domain.model.Product;
import com.inventario.xxi.domain.port.in.CreateProductCommand;
import com.inventario.xxi.domain.port.in.CreateProductUseCase;
import com.inventario.xxi.domain.port.in.ListProductsUseCase;
import com.inventario.xxi.domain.port.in.UpdateStockUseCase;
import com.inventario.xxi.infrastructure.rest.dto.CreateProductRequest;
import com.inventario.xxi.infrastructure.rest.dto.ProductResponse;
import com.inventario.xxi.infrastructure.rest.dto.UpdateStockRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final UpdateStockUseCase updateStockUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, ListProductsUseCase listProductsUseCase, UpdateStockUseCase updateStockUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
        this.updateStockUseCase = updateStockUseCase;
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

    @GetMapping
    public List<ProductResponse> listProducts(){
        return listProductsUseCase.listProducts()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @PutMapping("/{id}/stock")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStock(@PathVariable Long id, @Valid @RequestBody UpdateStockRequest request){
        updateStockUseCase.updateStock(id, request.getQuantity());
    }

    private ProductResponse mapToResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getMinStock(),
                product.isLowStock()
        );
    }
}
