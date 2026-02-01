package com.example.pws.controller;

import com.example.pws.exception.InvalidAmountException;
import com.example.pws.exception.UnauthorizedAccessException;
import com.example.pws.dto.GetTransactionRequest;
import com.example.pws.model.Transaction;
import com.example.pws.service.TransactionService;
import com.example.pws.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public List<Transaction > getAllTransactions(@PathVariable String id, @PathVariable String walletId ) throws UnauthorizedAccessException
    {
        boolean validateWalletId= userService.validateWalletId(id, walletId ) ;
//        if(validateWalletId== false ) {
//            return null ;
//        }
        List<Transaction > lis= transactionService.getAllTransactionsById(walletId ) ;
        return lis ;
    }

    @PostMapping("/make" )
    public Transaction postTransaction(@PathVariable String id,@Valid @RequestBody GetTransactionRequest request ) throws UnauthorizedAccessException, InvalidAmountException, MethodArgumentNotValidException
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
