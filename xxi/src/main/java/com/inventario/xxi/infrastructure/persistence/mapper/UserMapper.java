package com.inventario.xxi.infrastructure.persistence.mapper;

import com.inventario.xxi.domain.model.User;
import com.inventario.xxi.infrastructure.persistence.entity.UserEntity;

public class UserMapper {

    // Dominio → Entidad (para guardar)
    public static UserEntity toEntity(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                true
        );
    }

    // Entidad → Dominio (para leer)
    public static User toDomain(UserEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("UserEntity cannot be null");
        }
        User user =  new User(
                entity.getId(),
                entity.getEmail(),
                entity.getPassword()
        );
        return user;
    }
}
