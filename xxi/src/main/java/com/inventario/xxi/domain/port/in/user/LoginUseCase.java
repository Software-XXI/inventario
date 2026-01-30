package com.inventario.xxi.domain.port.in.user;

import com.inventario.xxi.domain.model.AuthToken;

public interface LoginUseCase {
        AuthToken login(UserCommand command);
}
