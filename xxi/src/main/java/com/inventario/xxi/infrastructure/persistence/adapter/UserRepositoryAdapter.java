package com.inventario.xxi.infrastructure.persistence.adapter;

import com.inventario.xxi.domain.model.User;
import com.inventario.xxi.domain.port.out.user.UserRepositoryPort;
import com.inventario.xxi.infrastructure.persistence.entity.UserEntity;
import com.inventario.xxi.infrastructure.persistence.mapper.UserMapper;
import com.inventario.xxi.infrastructure.persistence.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setActive(true);
        UserEntity saveUser = userJpaRepository.save(entity);
        return UserMapper.toDomain(saveUser);
    }

    @Override
    public boolean existingEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(UserMapper::toDomain);
    }
}
