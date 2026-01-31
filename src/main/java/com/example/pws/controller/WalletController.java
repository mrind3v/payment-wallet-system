package com.example.pws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<WalletResponse> getWalletById(@PathVariable Long walletId) {
        WalletResponse response = walletService.getWalletById(walletId);
        return ResponseEntity.ok(response);
    }

}
