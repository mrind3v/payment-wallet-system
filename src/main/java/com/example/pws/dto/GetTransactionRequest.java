package com.example.pws.dto;

import java.math.BigDecimal;

public class GetTransactionRequest {

    private String walletId ;
    private BigDecimal amount ;
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
