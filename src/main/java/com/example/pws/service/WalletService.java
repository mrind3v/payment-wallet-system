package com.example.pws.service;

/* import com.example.pws.dto.UpdateWalletRequest ; */
import com.example.pws.exception.ResourceNotFoundException;
import com.example.pws.model.Wallet;
import com.example.pws.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value= "wallet", key= "#id" )
    public Wallet getWalletById(String id ) throws ResourceNotFoundException
    {
        Wallet wallet= wr.findById(id ).orElse(null ) ;
        if (wallet==null) throw new ResourceNotFoundException("Wallet not found");
        return wallet ;
    }

    @CachePut(value= "wallet", key= "#id" )
    public Wallet updateWalletById(String id, BigDecimal balance ) throws ResourceNotFoundException
    {
        Wallet wallet= getWalletById(id ) ;
        if(balance!= null ) {
            wallet.setBalance(((wallet.getBalance() ).add(balance ) ) ) ;
        }
        wr.save(wallet ) ;
        return wallet ;
    }

    @CacheEvict(value= "wallet", key= "#id" )
    public void deleteWalletById(String id ) throws ResourceNotFoundException
    {
        Wallet wallet= getWalletById(id ) ;
        wr.deleteById(id ) ;
    }

    @Cacheable(value= "balance", key= "#id" )
    public BigDecimal getBalanceById(String id )
    {
        BigDecimal balance= wr.findBalanceById(id).orElse(null ) ;
        if (balance==null) throw new ResourceNotFoundException("Wallet not found");
        return balance;
    }
}
