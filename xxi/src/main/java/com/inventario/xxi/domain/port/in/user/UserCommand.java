package com.inventario.xxi.domain.port.in.user;

public record UserCommand(String email, String password){
    public UserCommand {
        if (email == null || email.isBlank() || password == null || password.isBlank()){
            throw new IllegalArgumentException("Email and password cannot be null or empty");
        }
    }
}
