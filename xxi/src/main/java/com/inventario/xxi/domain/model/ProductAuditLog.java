package com.inventario.xxi.domain.model;

import java.time.LocalDateTime;

public class ProductAuditLog {
    private final Long id;
    private final Long productId;
    private final Integer previousStock;
    private final Integer changeAmount;
    private final Integer newStock;
    private final LocalDateTime timestamp;
    private final String reason;

    public ProductAuditLog(Long id, Long productId, Integer previousStock, Integer changeAmount, Integer newStock, LocalDateTime timestamp, String reason) {
        this.id = id;
        this.productId = productId;
        this.previousStock = previousStock;
        this.changeAmount = changeAmount;
        this.newStock = newStock;
        this.timestamp = timestamp;
        this.reason = reason;
    }

    //Factory Method
    public static ProductAuditLog stockChange(Long productId, Integer previousStock, Integer changeAmount, Integer newStock, String reason){
        return new ProductAuditLog(
                null,
                productId,
                previousStock,
                changeAmount,
                newStock,
                LocalDateTime.now(),
                reason
        );
    }

    private static void validateStockChange(Long productId, Integer previousStock, Integer changeAmount, Integer newStock){
        if (productId.equals(null)){
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
        if(previousStock < 0 || changeAmount < 0 || newStock < 0){
            throw new IllegalArgumentException("Los valores de stock no pueden ser negativos");
        }
        if(!newStock.equals(previousStock + changeAmount)) {
            throw new IllegalArgumentException("El nuevo stock no coincide con la suma del stock anterior y el cambio");
        }
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getPreviousStock() {
        return previousStock;
    }

    public Integer getChangeAmount() {
        return changeAmount;
    }

    public Integer getNewStock() {
        return newStock;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getReason() {
        return reason;
    }
}