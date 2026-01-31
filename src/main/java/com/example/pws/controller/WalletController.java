package com.example.pws.controller;
import com.example.pws.model.Wallet;
import com.example.pws.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/users/{id}/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @GetMapping
    public ResponseEntity<Wallet> getWalletById(@PathVariable String id) {
        Wallet wallet = walletService.getWalletById(id);
        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal>  getWalletBalance(@PathVariable String id ) {
        Wallet wallet = walletService.getWalletById(id);
        return ResponseEntity.ok(wallet.getBalance());
    }
}
