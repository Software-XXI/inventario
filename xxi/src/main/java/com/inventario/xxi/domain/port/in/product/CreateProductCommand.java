package com.inventario.xxi.domain.port.in.product;

import java.math.BigDecimal;

public record CreateProductCommand(String name, String category, BigDecimal price, Integer stock, Integer minStock) {
    public CreateProductCommand{
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("El nombre es requerido");
        }
        if(category == null || category.isBlank()){
            throw new IllegalArgumentException("La categoria es requerida");
        }
        if(price == null || price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("El precio es requerido");
        }
        if(stock == null){
            throw new IllegalArgumentException("El stock es requerido");
        }
        if(minStock == null){
            throw new IllegalArgumentException("El stock minimo es requerido");
        }
        if(stock < minStock){
            throw new IllegalArgumentException("El stock no puede ser menor al stock minimo");
        }
    }
}
