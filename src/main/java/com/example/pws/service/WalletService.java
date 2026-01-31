package com.example.pws.service;

import com.example.pws.dto.UpdateWalletRequest;
import com.example.pws.model.Wallet;
import com.example.pws.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    @Autowired
    private WalletRepository wr ;

    public Wallet createWallet(BigDecimal balance )
    {
        Wallet wallet= new Wallet() ;
        wallet.setBalance(balance ) ;
        wallet.setStatus("ACTIVE" ) ;
        wr.save(wallet ) ;
        return wallet ;
    }

    public Wallet getWalletById(String id )
    {
        Wallet wallet= wr.findById(id ).orElse(null ) ;
        return wallet ;
    }

    public Wallet updateWalletById(String id, UpdateWalletRequest request )
    {
        Wallet wallet= getWalletById(id ) ;
        if(request.getBalance()!= null ) {
            wallet.setBalance(request.getBalance() ) ;
        }
        if(request.getStatus()!= null ) {
            wallet.setStatus(request.getStatus() ) ;
        }
        return wallet ;
    }

    public void deleteWalletById(String id )
    {
        Wallet wallet= getWalletById(id ) ;
        wr.deleteById(id ) ;
    }

    public BigDecimal getBalanceById(String id )
    {
        BigDecimal balance= wr.findBalanceById(id ).orElse(null ) ;
        return balance ;
    }
}
