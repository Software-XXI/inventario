package com.inventario.xxi.domain.model;

public class User {
    private Long id;
    private String email;
    private String password;
    private boolean active = true;

    public User(String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()){
            throw new IllegalArgumentException("Email and password cannot be null or empty");
        }
        this.email = email;
        this.password = password;
    }

    public User(Long id, String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("Email and password cannot be null or empty");
        }
        this.id = id;
        this.email = email;
        this.password = password;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }
}
