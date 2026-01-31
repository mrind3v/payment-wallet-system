package com.example.pws.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private String sender_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private String receiver_id;

    @NotNull
    @DecimalMin("0.0" )
    private BigDecimal amount;

    @Column(name = "created_at")
    private Date createdAt;

    public Transaction() {
        this.createdAt = new Date();
    }

    // getters & setters
}
