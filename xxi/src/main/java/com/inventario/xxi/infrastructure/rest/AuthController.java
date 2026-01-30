package com.inventario.xxi.infrastructure.rest;

import com.inventario.xxi.domain.model.User;
import com.inventario.xxi.domain.port.in.user.UserCommand;
import com.inventario.xxi.domain.port.in.user.RegisterUserUseCase;
import com.inventario.xxi.infrastructure.rest.dto.user_dto.RegisterRequest;
import com.inventario.xxi.infrastructure.rest.dto.user_dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final RegisterUserUseCase registerUserUseCase;
    public AuthController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterRequest request){
        UserCommand command = new UserCommand(request.getEmail(), request.getPassword());
        User user = registerUserUseCase.registerUser(command);
        return mapToResponse(user);
    }

    private UserResponse mapToResponse(User user){
        return new UserResponse(
                user.getEmail(),
                user.isActive()
        );
    }
}
