package com.example.pws.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    private String status;

    @NotNull
    @Column(name = "created_at")
    private Date createdAt;

    public User() {
        this.createdAt = new Date();
    }

    @NotNull
    private String walletId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getWalletId() {
        return walletId ;
    }

    public void setWalletId(String wallet_id) {
        this.walletId= wallet_id ;
    }
}
