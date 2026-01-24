package com.inventario.xxi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "audit_logs")
public class AuditLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Integer previousStock;
    @Column(nullable = false)
    private Integer changeAmount;
    @Column(nullable = false)
    private Integer newStock;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @Column(nullable = false)
    private String reason;
}
