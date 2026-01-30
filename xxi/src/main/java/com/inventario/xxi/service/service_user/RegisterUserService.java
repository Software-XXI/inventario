package com.inventario.xxi.service.service_user;

import com.inventario.xxi.domain.model.User;
import com.inventario.xxi.domain.model.UserAuditLog;
import com.inventario.xxi.domain.port.in.user.UserCommand;
import com.inventario.xxi.domain.port.in.user.RegisterUserUseCase;
import com.inventario.xxi.domain.port.out.audit.UserAuditLogRepositoryPort;
import com.inventario.xxi.domain.port.out.user.PasswordEncoderPort;
import com.inventario.xxi.domain.port.out.user.UserRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterUserService implements RegisterUserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final UserAuditLogRepositoryPort userAuditLogRepositoryPort;

    public RegisterUserService(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort, UserAuditLogRepositoryPort userAuditLogRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
        this.userAuditLogRepositoryPort = userAuditLogRepositoryPort;
    }

    @Override
    public User registerUser(UserCommand command){
        if(userRepositoryPort.existingEmail(command.email())){
            throw new RuntimeException("El correo electronico ya esta en uso");
        }
        String encodedPassword = passwordEncoderPort.encode(command.password());
        User user = new User(command.email(), encodedPassword);
        User userSaved = userRepositoryPort.save(user);
        UserAuditLog log = UserAuditLog.userRegistered(userSaved.getId());
        userAuditLogRepositoryPort.registerUser(log);
        return user;
    }

}
