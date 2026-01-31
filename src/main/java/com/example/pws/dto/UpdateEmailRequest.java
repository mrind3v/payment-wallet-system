package com.example.pws.dto;

import jakarta.validation.constraints.NotNull;

public class UpdateEmailRequest {

    @NotNull
    private String email;

    public String getMessage() {
        return email;
    }

    public void setMessage(String message) {
        this.email = message ;
    }
}
