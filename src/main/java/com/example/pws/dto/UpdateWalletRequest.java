package com.example.pws.dto;

import java.math.BigDecimal;

public class UpdateWalletRequest {

    private BigDecimal balance ;
    private String status ;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
