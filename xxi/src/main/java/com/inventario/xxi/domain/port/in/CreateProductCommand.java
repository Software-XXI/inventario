package com.inventario.xxi.domain.port.in;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateProductCommand {
    private final String name;
    private final String category;
    private final BigDecimal price;
    private final Integer stock;
    private final Integer minStock;

    public CreateProductCommand(String name, String category, BigDecimal price, Integer stock, Integer minStock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
    }
}
