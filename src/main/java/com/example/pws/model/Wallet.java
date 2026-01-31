package com.example.pws.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private String status;

    @NotNull
    @Column(name = "created_at")
    private Date createdAt;

    public Wallet() {
        this.createdAt = new Date();
    }
}
