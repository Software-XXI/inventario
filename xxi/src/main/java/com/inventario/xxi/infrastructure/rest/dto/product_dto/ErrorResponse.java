package com.inventario.xxi.infrastructure.rest.dto.product_dto;

import java.time.LocalDateTime;

public record ErrorResponse (String code, String message, LocalDateTime timestamp) {}
