package com.inventario.xxi.service.service_user;

import com.inventario.xxi.domain.model.AuthToken;
import com.inventario.xxi.domain.model.User;
import com.inventario.xxi.domain.model.UserAuditLog;
import com.inventario.xxi.domain.port.in.user.LoginUseCase;
import com.inventario.xxi.domain.port.in.user.UserCommand;
import com.inventario.xxi.domain.port.out.audit.UserAuditLogRepositoryPort;
import com.inventario.xxi.domain.port.out.security.JwtProviderPort;
import com.inventario.xxi.domain.port.out.user.PasswordEncoderPort;
import com.inventario.xxi.domain.port.out.user.UserRepositoryPort;
import com.inventario.xxi.infrastructure.rest.exception.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LoginUserService implements LoginUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final JwtProviderPort jwtProviderPort;
    private final UserAuditLogRepositoryPort userAuditLogRepositoryPort;

    public LoginUserService(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort, JwtProviderPort jwtProviderPort, UserAuditLogRepositoryPort userAuditLogRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
        this.jwtProviderPort = jwtProviderPort;
        this.userAuditLogRepositoryPort = userAuditLogRepositoryPort;
    }

    @Override
    public AuthToken login(UserCommand command) {
        if (command == null || command.email() == null || command.password() == null) {
            throw new RuntimeException("Email y contraseña son requeridos");
        }
        User user = userRepositoryPort.findByEmail(command.email()).orElseThrow(() -> new InvalidCredentialsException("Credenciales no válidad."));

        if (!user.isActive()){
            throw new UserInactiveException("Usuario inactivo.");
        }
        if (!passwordEncoderPort.matches(command.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Credenciales no válidas.");
        }
        try{
            String token = jwtProviderPort.generateToken(user);
            UserAuditLog log = UserAuditLog.userLogin(user.getId(), 0L);
            userAuditLogRepositoryPort.loginUser(log);
            return new AuthToken(token);
        }
        catch (Exception e){
            throw new AuthenticationException("Error al generar el token: " + e.getMessage());
        }
    }

}
