package com.inventario.xxi.infrastructure.rest.dto.user_dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank
    public String email;
    @NotBlank
    public String password;
}
