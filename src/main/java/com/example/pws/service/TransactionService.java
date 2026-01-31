package com.example.pws.service;

import com.example.pws.model.Transaction;
import com.example.pws.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List ;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository traRep ;

    public List<Transaction > getAllTransactionsById(String id )
    {
        List<Transaction > lis= traRep.findUserAById(id ).orElse(null ) ;
        return lis ;
    }
}
