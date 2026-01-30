package com.inventario.xxi.infrastructure.rest.dto.product_dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateStockRequest {
    @NotNull
    private Integer quantity;
}
