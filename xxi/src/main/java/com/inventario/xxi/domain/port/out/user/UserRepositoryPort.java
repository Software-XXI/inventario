package com.inventario.xxi.domain.port.out.user;

import com.inventario.xxi.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    boolean existingEmail(String email);
    Optional<User> findByEmail(String email);
    User save(User user);
}
