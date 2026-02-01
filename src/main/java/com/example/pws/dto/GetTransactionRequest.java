package com.example.pws.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class GetTransactionRequest {

    @NotBlank(message = "WalletId cannot be blank")
    private String walletId ;

    @NotNull(message = "Amount cannot be blank")
    private BigDecimal amount ;

    @NotBlank(message = "ReceiverId cannot be blank")
    private String receiverId ;

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId ;
    }
}
