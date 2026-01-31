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
    private String userA ;

    @NotNull
    private String userB ;

    @NotNull
    @DecimalMin("0.0" )
    private BigDecimal amount;

    @NotNull
    private String type ;

    @Column(name = "created_at")
    private Date createdAt;

    public Transaction() {
        this.createdAt = new Date();
    }

    // getters & setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type ;
    }

    public String getUserA() {
        return userA;
    }

    public void setUserA(String userA) {
        this.userA = userA;
    }

    public String getUserB() {
        return userB;
    }

    public void setUserB(String userB) {
        this.userB = userB ;
    }
}
