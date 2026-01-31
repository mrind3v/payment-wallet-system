package com.example.pws.controller;

import com.example.pws.dto.GetBalanceResponse;
import com.example.pws.model.Wallet;
import com.example.pws.service.WalletService;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/{id}/wallet" )
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<Wallet > getWalletById(@PathVariable String walletId) {
        Wallet response = walletService.getWalletById(walletId);
        return ResponseEntity.ok(response) ;
    }

    @GetMapping("/balance" )
    public GetBalanceResponse getBalanceById(@PathVariable String id)
    {
        GetBalanceResponse rs= new GetBalanceResponse() ;
        BigDecimal balance= walletService.getBalanceById(id ) ;
        rs.setBalance(balance ) ;
        return rs ;
    }
}
