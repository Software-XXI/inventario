package com.inventario.xxi.infrastructure.persistence.adapter;

import com.inventario.xxi.domain.port.out.user.PasswordEncoderPort;
import com.inventario.xxi.security.BCryptPasswordEncoderAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderAdapter implements PasswordEncoderPort {
    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordEncoderAdapter(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
