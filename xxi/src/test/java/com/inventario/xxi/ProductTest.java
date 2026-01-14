package com.inventario.xxi;

import com.inventario.xxi.domain.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void shouldCreateValidProduct(){
        Product product = new Product(1L, "Laptop", "Electronics", new java.math.BigDecimal("1000.00"), 10, 5);
        assertEquals(1L, product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals("Electronics", product.getCategory());
        assertEquals(new BigDecimal("1000.00"), product.getPrice());
        assertEquals(10, product.getStock());
        assertEquals(5, product.getMinStock());
    }

    @Test
    void shouldIncreaseStock(){
        Product product = new Product(1L, "Laptop", "Electronics", new java.math.BigDecimal("1000.00"), 10, 5);
        product.increaseStock(5);
        assertEquals(15, product.getStock());
    }

    @Test
    void shouldDecreaseStock(){
        Product product = new Product(1L, "Laptop", "Electronics", new java.math.BigDecimal("1000.00"), 10, 5);
        product.decreaseStock(5);
        assertEquals(5, product.getStock());
    }

    @Test
    void shouldDetectLowStock(){
        Product product = new Product(1L, "Laptop", "Electronics", new java.math.BigDecimal("1000.00"), 10, 15);
        assertTrue(product.isLowStock());
    }

    @Test
    void shouldThrowExceptionWhenStockGoesNegative(){
        Product product = new Product(1L, "Laptop", "Electronics", new java.math.BigDecimal("1000.00"), 10, 5);
        assertThrows(IllegalArgumentException.class, () -> product.decreaseStock(15));
    }
}
