package com.example.pws.controller;

import com.example.pws.model.Transaction;
import com.example.pws.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List ;

@RestController
@RequestMapping("/api/{id}/transactions" )
public class TransactionController {

    @Autowired
    private TransactionService transactionService ;

    @GetMapping("" )
    public List<Transaction > getAllTransactions(@PathVariable String id )
    {
        List<Transaction > lis= transactionService.getAllTransactionsById(id ) ;
        return lis ;
    }


}
