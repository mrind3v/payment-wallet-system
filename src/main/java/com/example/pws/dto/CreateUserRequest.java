package com.example.pws.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CreateUserRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name ;
    @Email(message = "Invalid Email")
    @NotBlank(message = "Email cannot be blank")
    private String email ;

    @NotNull(message = "Balance should be greater than 0")
    @DecimalMin("0.0" )
    private BigDecimal balance ;

    @NotBlank(message = "Password should not be blank")
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
