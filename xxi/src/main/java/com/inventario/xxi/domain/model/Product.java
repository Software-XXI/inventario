package com.inventario.xxi.domain.model;


import java.math.BigDecimal;

/*
🎯 Responsabilidad del dominio

    -Mantener estado válido
    -Aplicar reglas de negocio
    -No saber nada de:
        📦 Infraestructura
        1 JPA
        2 Spring
        3 HTTP
        4 JSON
 */
public class Product {
    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private Integer stock;
    private Integer minStock;

    public Product(Long id, String name, String category, BigDecimal price, Integer stock, Integer minStock){
        validate(name, category, price, stock, minStock);
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
    }

    // Validar
    private void validate(String name, String category, BigDecimal price, Integer stock, Integer minStock){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("El nombre es requerido");
        }
        if(category == null || category.isBlank()){
            throw new IllegalArgumentException("La categoria es requerida");
        }
        if(price == null || price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("El precio es requerido");
        }
        if(stock == null || stock < 0){
            throw new IllegalArgumentException("El stock es requerido");
        }
        if(minStock == null || minStock < 0){
            throw new IllegalArgumentException("El stock minimo es requerido");
        }
        if(stock < minStock){
            throw new IllegalArgumentException("El stock no puede ser menor al stock minimo");
        }
    }

    //Reglas de negocio
    public void increaseStock(Integer quantity){
        if(quantity == null || quantity < 0){
            throw new IllegalArgumentException("La cantidad es requerida");
        }
        this.stock += quantity;
    }

    public void decreaseStock(Integer quantity){
        if(quantity == null || quantity < 0){
            throw new IllegalArgumentException("La cantidad es requerida");
        }
        if(quantity > stock){
            throw new IllegalArgumentException("No hay suficiente stock");
        }
        this.stock -= quantity;
    }

    public Boolean isLowStock(){
        return stock < minStock;
    }

    // Getter
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public Integer getStock() {
        return stock;
    }
    public Integer getMinStock() {
        return minStock;
    }
}
