package com.inventario.xxi.domain.port.in.user;

import com.inventario.xxi.domain.model.User;

public interface RegisterUserUseCase {
    User registerUser(UserCommand command);
}
