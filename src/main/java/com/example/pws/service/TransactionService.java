package com.example.pws.service;

import com.example.pws.exception.InvalidAmountException;
import com.example.pws.exception.UnauthorizedAccessException;
import com.example.pws.dto.GetTransactionRequest;
import com.example.pws.model.Transaction;
import com.example.pws.model.Wallet;
import com.example.pws.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value= "transactions", key= "#id" )
    public List<Transaction > getAllTransactionsById(String id )
    {
        List<Transaction > lis= traRep.findUserAById(id ).orElse(null ) ;
        return lis ;
    }

    public boolean validateBalance(String userId, GetTransactionRequest request ) throws UnauthorizedAccessException, InvalidAmountException
    {
        boolean validateWallet= userService.validateWalletId(userId, request.getWalletId() ) ;
        if(validateWallet== false ) {
            throw new UnauthorizedAccessException("Invalid access to wallet");
        }
        Wallet wallet= walletService.getWalletById(request.getWalletId() ) ;
        BigDecimal newBigDecimal = new BigDecimal("0.0");
        if((wallet.getBalance() ).compareTo((request.getAmount() ) )== -1  || (request.getAmount().compareTo(newBigDecimal)==-1)) {
            throw new InvalidAmountException("Invalid amount");
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
        walletService.updateWalletById(request.getWalletId(), (request.getAmount() ) ) ;
        walletService.updateWalletById((request.getReceiverId() ), ((num ).multiply((request.getAmount() ) ) ) ) ;
        return transaction ;
    }
}
