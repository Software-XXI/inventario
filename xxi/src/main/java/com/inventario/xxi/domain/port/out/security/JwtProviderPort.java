package com.inventario.xxi.domain.port.out.security;

import com.inventario.xxi.domain.model.User;

public interface JwtProviderPort {
    String generateToken(User user);
    boolean validateToken(String token);
    String getEmailFromToken(String token);
}
