package com.example.pws.controller;

import com.example.pws.dto.GetTransactionRequest;
import com.example.pws.model.Transaction;
import com.example.pws.service.TransactionService;
import com.example.pws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List ;

@RestController
@RequestMapping("/api/{id}/transactions" )
public class TransactionController {

    @Autowired
    private TransactionService transactionService ;

    @Autowired
    private UserService userService ;

    @GetMapping("/{walletId}" )
    public List<Transaction > getAllTransactions(@PathVariable String id, @PathVariable String walletId )
    {
        List<Transaction > lis= transactionService.getAllTransactionsById(id ) ;
        return lis ;
    }

    @PostMapping("/make" )
    public Transaction postTransaction(@PathVariable String id, @RequestBody GetTransactionRequest request )
    {
        boolean validate= transactionService.validateBalance(id, request ) ;
        Transaction transaction ;
        if(validate== true ) {
            transaction = transactionService.createTransaction(request) ;
        }
        else {
            transaction = null;
        }
        return transaction ;
    }


}
