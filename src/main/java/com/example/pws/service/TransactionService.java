package com.example.pws.service;

import com.example.pws.dto.GetTransactionRequest;
import com.example.pws.model.Transaction;
import com.example.pws.model.Wallet;
import com.example.pws.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List ;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository traRep ;

    @Autowired
    private WalletService walletService ;

    @Autowired
    private UserService userService ;

    public List<Transaction > getAllTransactionsById(String id )
    {
        List<Transaction > lis= traRep.findUserAById(id ).orElse(null ) ;
        return lis ;
    }

    public boolean validateBalance(String userId, GetTransactionRequest request )
    {
        boolean validateWallet= userService.validateWalletId(userId, request.getWalletId() ) ;
        if(validateWallet== false ) {
            return false;
        }
        Wallet wallet= walletService.getWalletById(request.getWalletId() ) ;
        if((wallet.getBalance() ).compareTo((request.getAmount() ) )== -1 ) {
            return false ;
        }
        return true ;
    }

    @Transactional
    public Transaction createTransaction(GetTransactionRequest request )
    {
        Transaction transaction= new Transaction() ;
        transaction.setUserA(request.getWalletId() ) ;
        transaction.setAmount(request.getAmount() ) ;
        transaction.setUserB(request.getReceiverId() ) ;
        transaction.setType("SUCCESSFUL" ) ;
        Transaction transaction_new= new Transaction() ;
        transaction_new.setUserA(request.getReceiverId() ) ;
        BigDecimal num= new BigDecimal("-1" ) ;
        transaction_new.setAmount((num ).multiply(request.getAmount() ) ) ;
        transaction_new.setUserB(request.getWalletId() ) ;
        transaction_new.setType("SUCCESSFUL" ) ;
        traRep.save(transaction ) ;
        traRep.save(transaction_new ) ;
        return transaction ;
    }
}
