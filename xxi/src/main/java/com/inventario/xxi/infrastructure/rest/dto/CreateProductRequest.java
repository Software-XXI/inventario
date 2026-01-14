package com.inventario.xxi.infrastructure.rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @NotNull
    @Positive
    private BigDecimal price;
    @Min(0)
    private Integer stock;
    @Min(0)
    private Integer minStock;
}
