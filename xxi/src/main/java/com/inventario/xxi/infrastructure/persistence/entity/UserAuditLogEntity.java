package com.inventario.xxi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_audit_logs")
public class UserAuditLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @Column(nullable = false)
    private String action;
    private String entityType;
    private Long entityId;
    private Long commerceId;
    private boolean active;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    // getters y setters
}

