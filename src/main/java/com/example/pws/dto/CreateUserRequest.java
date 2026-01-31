package com.example.pws.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateUserRequest {

    @NotNull
    private String name ;
    @NotNull
    private String email ;

    @NotNull
    private BigDecimal balance ;

    @NotNull
    private String password ;

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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
