package com.example.pws.controller;
import com.example.pws.dto.GetBalanceResponse;
import com.example.pws.model.Wallet;
import com.example.pws.service.UserService;
import com.example.pws.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/{id}/wallet")
public class WalletController {

    @Autowired
    private final WalletService walletService ;

    @Autowired
    private UserService userService ;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable String id, @PathVariable String walletId) {
        userService.validateWalletId(id, walletId ) ;
        Wallet response = walletService.getWalletById(walletId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/balance/{walletId}")
    public GetBalanceResponse getBalanceById(@PathVariable String id, @PathVariable String walletId) {
        userService.validateWalletId(id, walletId ) ;
        GetBalanceResponse rs = new GetBalanceResponse();
        BigDecimal balance = walletService.getBalanceById(walletId);
        rs.setBalance(balance);
        System.out.println("===================================================");
        System.out.println(balance);
        return rs;
    }
}
