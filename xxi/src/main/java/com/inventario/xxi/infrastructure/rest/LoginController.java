package com.inventario.xxi.infrastructure.rest;

import com.inventario.xxi.domain.model.AuthToken;
import com.inventario.xxi.domain.port.in.user.LoginUseCase;
import com.inventario.xxi.domain.port.in.user.UserCommand;
import com.inventario.xxi.infrastructure.rest.dto.user_dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthToken> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(loginUseCase.login(new UserCommand(request.email, request.password)));
    }
}
