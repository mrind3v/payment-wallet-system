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
    private String wallet_id;


}
